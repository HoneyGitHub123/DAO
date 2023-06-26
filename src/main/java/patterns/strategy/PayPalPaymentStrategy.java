package patterns.strategy;

public class PayPalPaymentStrategy implements PaymentStrategy {

    private String emailID;
    private String password;


    public PayPalPaymentStrategy(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }


    @Override
    public double getPayment(double amount) {
        System.out.println("Amount paid with Paypal:");
        return amount;
    }
}
