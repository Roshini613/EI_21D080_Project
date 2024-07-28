import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer Interface
interface Observer {
    void update(String stockSymbol, double price);
}

// Subject Interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Subject {
    private List<Observer> observers;
    private String stockSymbol;
    private double price;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }
}

// Concrete Observer
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Investor " + name + " - Stock Update:");
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Price: $" + price);
    }
}

// Concrete Observer
class Analyst implements Observer {
    private String name;

    public Analyst(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Analyst " + name + " - Stock Update:");
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Price: $" + price);
    }
}

// Client Code
public class BehaviouralObserver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a StockMarket subject
        StockMarket stockMarket = new StockMarket();

        // Create observers (Investors and Analysts)
        System.out.print("Enter number of investors: ");
        int numInvestors = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Observer> investors = new ArrayList<>();
        for (int i = 0; i < numInvestors; i++) {
            System.out.print("Enter investor name: ");
            String name = scanner.nextLine();
            investors.add(new Investor(name));
        }

        System.out.print("Enter number of analysts: ");
        int numAnalysts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Observer> analysts = new ArrayList<>();
        for (int i = 0; i < numAnalysts; i++) {
            System.out.print("Enter analyst name: ");
            String name = scanner.nextLine();
            analysts.add(new Analyst(name));
        }

        // Register all investors and analysts with stock market
        for (Observer investor : investors) {
            stockMarket.registerObserver(investor);
        }
        for (Observer analyst : analysts) {
            stockMarket.registerObserver(analyst);
        }

        // Get stock updates from user
        while (true) {
            System.out.print("Enter stock symbol (or 'exit' to quit): ");
            String stockSymbol = scanner.nextLine();
            if (stockSymbol.equalsIgnoreCase("exit")) break;

            System.out.print("Enter stock price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Update stock price and notify observers
            stockMarket.setStockPrice(stockSymbol, price);
        }

        scanner.close();
    }
}