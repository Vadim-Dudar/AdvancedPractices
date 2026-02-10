package edu.naukma.theme5;

public class MultiNotifier implements SmsNotifier, EmailNotifier{

    @Override
    public void send() {
        SmsNotifier.super.send();
        EmailNotifier.super.send();
    }

}
