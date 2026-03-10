package edu.naukma.theme7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class ReceiptWriter implements AutoCloseable {

    public ReceiptWriter() {
        super();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing..");
        System.out.println("Closed!");
    }
}

class ReceiptService {
    private static final Logger log = LoggerFactory.getLogger(ReceiptService.class);

    public String generate() {
        try (var writer = new ReceiptWriter()) {
            System.out.println("Do some!");
            return "Full receipt";
        } catch (Exception e) {
            log.warn("...");
        }
        return "(((";
    }
}

class ReceiptGenerationException extends IOException {
    public ReceiptGenerationException(String m) {
        super(m);
    }

    public ReceiptGenerationException(String m, Throwable e) {
        super(m, e);
    }
}

public class Task3 {
    public static void main(String[] args) {
        ReceiptService service = new ReceiptService();
        System.out.println(service.generate());
    }
}
