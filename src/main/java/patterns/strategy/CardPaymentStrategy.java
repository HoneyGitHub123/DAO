package patterns.strategy;

public class CardPaymentStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;


    public CardPaymentStrategy(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getPayment(double amount) {
        System.out.println("Amount paid with credit/debit card:");
        return amount;
    }
}
