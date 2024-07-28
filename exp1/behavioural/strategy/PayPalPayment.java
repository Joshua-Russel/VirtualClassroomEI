package behavioural.strategy;

// Concrete Strategy
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(float amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }
}
