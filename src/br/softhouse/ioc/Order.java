package br.softhouse.ioc;

public class Order {

    private final SendEmails sendEmails = SendEmails.getDataEmail();

    public static void main(String[] args) {
        Order order = new Order();
        order.save();
    }

    public void save() {

        // excess of responsibility: moved to sendEmails class
        //sendEmails = new SendEmails("stmp", "contact@email.com", "password");

        sendEmails.success("Order created!");
    }

}
