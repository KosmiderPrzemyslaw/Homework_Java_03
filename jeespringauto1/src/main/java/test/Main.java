package test;

public class Main {
    public static void main(String[] args) {
        MessageSender messageSenderEmail = new MessageSender(new EmailSender(), "email message");
        messageSenderEmail.sendMessage();

        MessageSender messageSenderSms = new MessageSender(new SmsSender(), "Sms message");
        messageSenderSms.sendMessage();
    }
}
