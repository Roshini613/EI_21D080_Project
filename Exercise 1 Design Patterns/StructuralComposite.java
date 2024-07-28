import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Component Interface
interface OrganizationUnit {
    void showDetails();
}

// Leaf Class
class Employee implements OrganizationUnit {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

// Composite Class
class Department implements OrganizationUnit {
    private String name;
    private List<OrganizationUnit> units = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addUnit(OrganizationUnit unit) {
        units.add(unit);
    }

    public void removeUnit(OrganizationUnit unit) {
        units.remove(unit);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (OrganizationUnit unit : units) {
            unit.showDetails();
        }
    }
}

// Client Code
public class StructuralComposite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create departments
        System.out.print("Enter the name of the IT Department: ");
        Department itDept = new Department(scanner.nextLine());

        System.out.print("Enter the name of the HR Department: ");
        Department hrDept = new Department(scanner.nextLine());

        // Create and add teams to the IT Department
        System.out.print("Enter the name of the Development Team: ");
        Department devTeam = new Department(scanner.nextLine());

        System.out.print("Enter the name of the Design Team: ");
        Department designTeam = new Department(scanner.nextLine());

        itDept.addUnit(devTeam);
        itDept.addUnit(designTeam);

        // Add employees to teams
        System.out.print("Enter the number of employees for the Development Team: ");
        int devTeamSize = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < devTeamSize; i++) {
            System.out.print("Enter the name of employee " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter the position of employee " + (i + 1) + ": ");
            String position = scanner.nextLine();
            devTeam.addUnit(new Employee(name, position));
        }

        System.out.print("Enter the number of employees for the Design Team: ");
        int designTeamSize = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < designTeamSize; i++) {
            System.out.print("Enter the name of employee " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter the position of employee " + (i + 1) + ": ");
            String position = scanner.nextLine();
            designTeam.addUnit(new Employee(name, position));
        }

        // Print organization details
        System.out.println("\nOrganization Structure:");
        itDept.showDetails();
        hrDept.showDetails(); // HR Department has no sub-units but still shows up in the hierarchy

        scanner.close();
    }
}