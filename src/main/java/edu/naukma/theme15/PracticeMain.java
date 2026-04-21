package edu.naukma.theme15;

import java.lang.reflect.InvocationTargetException;

public class PracticeMain {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        task 1
        ClassInfoPrinter.print(Book.class);
//        task 2
        PaymentService service = ServiceFactory.create("edu.naukma.theme15.CardPaymentService");
        ClassInfoPrinter.print(service.getClass());
//        task 3
        SetupFlow runner = new SetupFlow();
        StepRunner.run(runner);
        System.out.println(runner.executed());
    }
}
