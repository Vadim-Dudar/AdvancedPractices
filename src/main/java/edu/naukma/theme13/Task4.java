package edu.naukma.theme13;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

record SupportTicket(long id, String customer, String topic) {
}

class TicketQueue {
	static final SupportTicket POISON_PILL = new SupportTicket(-1L, "STOP", "STOP");
	private final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>();

	void put(SupportTicket ticket) throws InterruptedException {
		queue.put(ticket);
	}

	SupportTicket take() throws InterruptedException {
		return queue.take();
	}
}

class TicketProducer implements Runnable {
	private final TicketQueue queue;
	private final List<SupportTicket> tickets;
	private final int consumers;

	TicketProducer(TicketQueue queue, List<SupportTicket> tickets, int consumers) {
		this.queue = queue;
		this.tickets = tickets;
		this.consumers = consumers;
	}

	@Override
	public void run() {
		try {
			for (SupportTicket ticket : tickets) {
				queue.put(ticket);
			}
			for (int i = 0; i < consumers; i++) {
				queue.put(TicketQueue.POISON_PILL);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

class TicketConsumer implements Runnable {
	private final TicketQueue queue;
	private final ConcurrentHashMap<String, Integer> topicCount;

	TicketConsumer(TicketQueue queue, ConcurrentHashMap<String, Integer> topicCount) {
		this.queue = queue;
		this.topicCount = topicCount;
	}

	@Override
	public void run() {
		try {
			while (true) {
				SupportTicket ticket = queue.take();
				if (ticket == TicketQueue.POISON_PILL) {
					return;
				}
				topicCount.merge(ticket.topic(), 1, Integer::sum);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class Task4 {
	public static void main(String[] args) throws InterruptedException {
		TicketQueue queue = new TicketQueue();
		ConcurrentHashMap<String, Integer> topicCount = new ConcurrentHashMap<>();

		List<SupportTicket> tickets = List.of(
				new SupportTicket(1, "Anna", "billing"),
				new SupportTicket(2, "Max", "login"),
				new SupportTicket(3, "Ira", "billing"),
				new SupportTicket(4, "Oleh", "delivery"),
				new SupportTicket(5, "Nina", "login")
		);

		int consumers = 2;
		Thread c1 = new Thread(new TicketConsumer(queue, topicCount), "consumer-1");
		Thread c2 = new Thread(new TicketConsumer(queue, topicCount), "consumer-2");
		Thread producer = new Thread(new TicketProducer(queue, tickets, consumers), "producer");

		c1.start();
		c2.start();
		producer.start();

		producer.join();
		c1.join();
		c2.join();

		for (Map.Entry<String, Integer> e : topicCount.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
	}
}
