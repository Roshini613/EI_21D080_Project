import java.util.Scanner;

// Abstract class defining the template method
abstract class OrderProcessor {
    // Template method
    public final void processOrder() {
        validateOrder();
        collectCustomerDetails();
        calculateTotal();
        prepareShipping();
        deliverOrder();
    }

    // Concrete method
    private void validateOrder() {
        System.out.println("Validating order...");
    }

    // New abstract method for collecting customer details
    protected abstract void collectCustomerDetails();
    
    // Abstract methods to be implemented by subclasses
    protected abstract void calculateTotal();
    protected abstract void prepareShipping();
    protected abstract void deliverOrder();
}

// Concrete class for Physical Goods Orders
class PhysicalGoodsOrder extends OrderProcessor {
    private String shippingAddress;
    private double orderAmount;

    @Override
    protected void collectCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter shipping address for physical goods: ");
        shippingAddress = scanner.nextLine();
    }

    @Override
    protected void calculateTotal() {
        // Placeholder for calculation logic
        System.out.println("Calculating total for physical goods order. Amount: $" + (orderAmount = 50.00));
    }

    @Override
    protected void prepareShipping() {
        System.out.println("Packing physical goods for shipping to: " + shippingAddress);
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Shipping physical goods to address: " + shippingAddress);
    }
}

// Concrete class for Digital Goods Orders
class DigitalGoodsOrder extends OrderProcessor {
    private String email;
    private double orderAmount;

    @Override
    protected void collectCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email address for digital goods: ");
        email = scanner.nextLine();
    }

    @Override
    protected void calculateTotal() {
        // Placeholder for calculation logic
        System.out.println("Calculating total for digital goods order. Amount: $" + (orderAmount = 20.00));
    }

    @Override
    protected void prepareShipping() {
        System.out.println("Preparing digital goods for download. Sending link to: " + email);
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Sending download link to email: " + email);
    }
}

// Concrete class for Subscription Orders
class SubscriptionOrder extends OrderProcessor {
    private String subscriptionPlan;
    private double orderAmount;

    @Override
    protected void collectCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter subscription plan (e.g., Monthly, Yearly): ");
        subscriptionPlan = scanner.nextLine();
    }

    @Override
    protected void calculateTotal() {
        // Placeholder for calculation logic
        orderAmount = subscriptionPlan.equalsIgnoreCase("Yearly") ? 100.00 : 10.00;
        System.out.println("Calculating total for subscription order. Amount: $" + orderAmount);
    }

    @Override
    protected void prepareShipping() {
        System.out.println("Preparing subscription details for plan: " + subscriptionPlan);
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Sending subscription confirmation for plan: " + subscriptionPlan);
    }
}

// Client Code
public class BehaviouralTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the type of order
        System.out.println("Enter order type (physical/digital/subscription): ");
        String orderType = scanner.nextLine().toLowerCase();

        // Create appropriate order processor based on user input
        OrderProcessor orderProcessor;
        switch (orderType) {
            case "physical":
                orderProcessor = new PhysicalGoodsOrder();
                break;
            case "digital":
                orderProcessor = new DigitalGoodsOrder();
                break;
            case "subscription":
                orderProcessor = new SubscriptionOrder();
                break;
            default:
                System.out.println("Invalid order type.");
                scanner.close();
                return;
        }

        // Process the order
        orderProcessor.processOrder();

        scanner.close();
    }
}