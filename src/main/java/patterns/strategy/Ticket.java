package patterns.strategy;

public class Ticket {

    private int passengerID;
    private String ticketNo;
    private double price;

    private PaymentStrategy paymentStrategy;
    public Ticket(int passengerID, String ticketNo, double price, PaymentStrategy paymentStrategy) {
        this.passengerID = passengerID;
        this.ticketNo = ticketNo;
        this.price = price;
        this.paymentStrategy = paymentStrategy;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public double getPrice() {
        return price;
    }

    public double getPayment() {

        return paymentStrategy.getPayment(price);
    }
}