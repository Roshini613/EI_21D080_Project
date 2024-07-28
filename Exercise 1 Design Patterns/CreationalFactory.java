import java.util.Scanner;

// ElectronicComponent.java
interface ElectronicComponent {
    void handle();
}

// Resistor.java
class Resistor implements ElectronicComponent {
    private double resistanceValue;

    public Resistor(double resistanceValue) {
        this.resistanceValue = resistanceValue;
    }

    @Override
    public void handle() {
        System.out.println("Handling resistor with resistance value: " + resistanceValue + " ohms");
    }
}

// Capacitor.java
class Capacitor implements ElectronicComponent {
    private double capacitanceValue;

    public Capacitor(double capacitanceValue) {
        this.capacitanceValue = capacitanceValue;
    }

    @Override
    public void handle() {
        System.out.println("Handling capacitor with capacitance value: " + capacitanceValue + " farads");
    }
}

// Transistor.java
class Transistor implements ElectronicComponent {
    private double gainValue;

    public Transistor(double gainValue) {
        this.gainValue = gainValue;
    }

    @Override
    public void handle() {
        System.out.println("Handling transistor with gain value: " + gainValue);
    }
}

// ElectronicComponentFactory.java
abstract class ElectronicComponentFactory {
    public abstract ElectronicComponent createElectronicComponent();
}

// ResistorFactory.java
class ResistorFactory extends ElectronicComponentFactory {
    private double resistanceValue;

    public ResistorFactory(double resistanceValue) {
        this.resistanceValue = resistanceValue;
    }

    @Override
    public ElectronicComponent createElectronicComponent() {
        return new Resistor(resistanceValue);
    }
}

// CapacitorFactory.java
class CapacitorFactory extends ElectronicComponentFactory {
    private double capacitanceValue;

    public CapacitorFactory(double capacitanceValue) {
        this.capacitanceValue = capacitanceValue;
    }

    @Override
    public ElectronicComponent createElectronicComponent() {
        return new Capacitor(capacitanceValue);
    }
}

// TransistorFactory.java
class TransistorFactory extends ElectronicComponentFactory {
    private double gainValue;

    public TransistorFactory(double gainValue) {
        this.gainValue = gainValue;
    }

    @Override
    public ElectronicComponent createElectronicComponent() {
        return new Transistor(gainValue);
    }
}

// ComponentManagementService.java
class ComponentManagementService {
    private ElectronicComponentFactory componentFactory;

    public ComponentManagementService(ElectronicComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public void manageComponent() {
        ElectronicComponent component = componentFactory.createElectronicComponent();
        component.handle();
    }
}

// Main.java
public class CreationalFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select component type: 1. Resistor 2. Capacitor 3. Transistor");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter resistance value (in ohms): ");
                double resistanceValue = scanner.nextDouble();
                ComponentManagementService resistorService = new ComponentManagementService(new ResistorFactory(resistanceValue));
                resistorService.manageComponent();
                break;

            case 2:
                System.out.print("Enter capacitance value (in farads): ");
                double capacitanceValue = scanner.nextDouble();
                ComponentManagementService capacitorService = new ComponentManagementService(new CapacitorFactory(capacitanceValue));
                capacitorService.manageComponent();
                break;

            case 3:
                System.out.print("Enter gain value: ");
                double gainValue = scanner.nextDouble();
                ComponentManagementService transistorService = new ComponentManagementService(new TransistorFactory(gainValue));
                transistorService.manageComponent();
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}