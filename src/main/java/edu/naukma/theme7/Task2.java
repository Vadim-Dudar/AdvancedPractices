package edu.naukma.theme7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void checkout(Order order)  {
        try {
            unsafe();
        } catch (PaymentGatewayExeption e) {
            log.error("Payment gateway e for order ID: {} Email: {}", order.id(), order.userEmail(), e);
            throw new OrderProcessingException("Payment gateway e for order ID: " + order.id(), e);
        }
        log.info("Successful order for ID: {}", order.id());
    }

    public void unsafe() throws PaymentGatewayExeption {
        log.warn("Card declined!");
        throw new PaymentGatewayExeption("Some m");
    }
}

public class Task2 {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        service.checkout(new Order(5, "some@mail.com", 3000));
    }
}
