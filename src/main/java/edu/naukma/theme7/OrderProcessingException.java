package edu.naukma.theme7;

public class OrderProcessingException extends RuntimeException {
    public OrderProcessingException(String message) {
        super(message);
    }
    public OrderProcessingException(String m, Throwable e) {super(m, e);}
}
