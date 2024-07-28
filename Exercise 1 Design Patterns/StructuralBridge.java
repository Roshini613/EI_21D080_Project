import java.util.Scanner;

// Implementor Interface
interface PaymentMethod {
    void processPayment(double amount);
}

// Concrete Implementors
class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPal implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Abstraction
abstract class Transaction {
    protected PaymentMethod paymentMethod;

    protected Transaction(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    abstract void execute(double amount);
}

// Refined Abstractions
class Purchase extends Transaction {
    public Purchase(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    void execute(double amount) {
        System.out.println("Executing purchase transaction...");
        paymentMethod.processPayment(amount);
    }
}

class Refund extends Transaction {
    public Refund(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    void execute(double amount) {
        System.out.println("Executing refund transaction...");
        paymentMethod.processPayment(amount);
    }
}

// Client Code
public class StructuralBridge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for payment method
        System.out.println("Select Payment Method: ");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        PaymentMethod paymentMethod = null;
        switch (choice) {
            case 1:
                paymentMethod = new CreditCard();
                break;
            case 2:
                paymentMethod = new PayPal();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Prompt user for transaction type
        System.out.println("Select Transaction Type: ");
        System.out.println("1. Purchase");
        System.out.println("2. Refund");
        System.out.print("Enter choice (1 or 2): ");
        int transactionType = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Transaction transaction = null;
        switch (transactionType) {
            case 1:
                transaction = new Purchase(paymentMethod);
                break;
            case 2:
                transaction = new Refund(paymentMethod);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Prompt user for amount
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        // Execute transaction
        transaction.execute(amount);

        scanner.close();
    }
}