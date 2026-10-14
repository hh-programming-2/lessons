package lesson4;

/**
 * The purpose of this example is to demonstrate interfaces and the usage of
 * Dependency Injection pattern.
 */
public class DependencyInjection {
    public static void main(String[] args) {
        // The code creating the cart chooses a payment method and passes it in.
        // This is dependency injection: ShoppingCart does not create the payment
        // method itself, it receives the dependency from its caller
        PaymentMethod creditCard = new CreditCardPayment();
        ShoppingCart cardCart = new ShoppingCart(creditCard);
        cardCart.checkout(25.50);

        // Passing a different implementation changes the payment behavior,
        // without changing ShoppingCart or its checkout method
        PaymentMethod paypal = new PayPalPayment();
        ShoppingCart paypalCart = new ShoppingCart(paypal);
        paypalCart.checkout(42.00);
    }

}

interface PaymentMethod {
    void pay(double amount);
}

// Each payment option implements the same interface, so the cart can use it
// without depending on the details of a particular payment provider.
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        // Here we would send a payment request to the credit card system...
        System.out.println("Paid " + amount + " euros using credit card");
    }
}

 class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        // Here we would send a payment request to PayPal...
        System.out.println("Paid " + amount + " euros using PayPal");
    }
}

class ShoppingCart {
    // The cart depends on the PaymentMethod abstraction, not a specific class.
    private PaymentMethod paymentMethod;

    // Constructor injection: the caller supplies the dependency when creating
    // the cart, making the payment method easy to replace.
    public ShoppingCart(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(double total) {
        // Dispatches to the implementation that was injected into this cart.
        paymentMethod.pay(total);
    }
}
