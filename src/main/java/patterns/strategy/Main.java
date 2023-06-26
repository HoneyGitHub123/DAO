package patterns.strategy;

//Followed open closed SOLID design principle
public class Main {

    public static void main(String[] args) {
        //Make ticket payment using card payment strategy
        CardPaymentStrategy cardPay = new CardPaymentStrategy("AMEX", "1234567890123456", "890", "MAR2025");
        Ticket ticket1 = new Ticket(1001, "TKCT456", 345, cardPay);
        System.out.println("PassengerID:" + ticket1.getPassengerID());
        System.out.println("Ticket Number:" + ticket1.getTicketNo());
        System.out.println("Ticket Price:" + ticket1.getPrice());
        System.out.println(ticket1.getPayment());

        //Make ticket payment using paypal payment strategy
        PayPalPaymentStrategy payPal = new PayPalPaymentStrategy("avgb34@gmail.com", "hagg45@gma");
        Ticket ticket2 = new Ticket(1901, "TKCT496", 395, payPal);
        System.out.println("PassengerID:" + ticket2.getPassengerID());
        System.out.println("Ticket Number:" + ticket2.getTicketNo());
        System.out.println("Ticket Price:" + ticket2.getPrice());
        System.out.println(ticket2.getPayment());


    }
}
