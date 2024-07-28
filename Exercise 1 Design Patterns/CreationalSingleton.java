import java.util.Scanner;

public class CreationalSingleton{

    // Singleton ConfigurationManager Class
    public static class ConfigurationManager {
        private static ConfigurationManager instance;
        private String networkSettings;
        private String userPreferences;
        private String systemMode;

        // Private constructor to prevent instantiation
        private ConfigurationManager() {
            // Initialize with default settings
            this.networkSettings = "DefaultNetwork";
            this.userPreferences = "DefaultPreferences";
            this.systemMode = "Normal";
        }

        // Method to get the single instance of the class
        public static synchronized ConfigurationManager getInstance() {
            if (instance == null) {
                instance = new ConfigurationManager();
            }
            return instance;
        }

        // Getters and setters for configuration settings
        public String getNetworkSettings() {
            return networkSettings;
        }

        public void setNetworkSettings(String networkSettings) {
            this.networkSettings = networkSettings;
            notifyAllDevices();
        }

        public String getUserPreferences() {
            return userPreferences;
        }

        public void setUserPreferences(String userPreferences) {
            this.userPreferences = userPreferences;
            notifyAllDevices();
        }

        public String getSystemMode() {
            return systemMode;
        }

        public void setSystemMode(String systemMode) {
            this.systemMode = systemMode;
            notifyAllDevices();
        }

        // Method to notify all devices about configuration updates
        private void notifyAllDevices() {
            System.out.println("Configuration updated. Notifying all devices...");
            // Implement actual notification logic here
        }
    }

    // SmartDevice Class that uses ConfigurationManager
    public static class SmartDevice {
        public void printConfiguration() {
            ConfigurationManager config = ConfigurationManager.getInstance();
            System.out.println("Current Network Settings: " + config.getNetworkSettings());
            System.out.println("Current User Preferences: " + config.getUserPreferences());
            System.out.println("Current System Mode: " + config.getSystemMode());
        }
    }

    // Client Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the single instance of ConfigurationManager
        ConfigurationManager config = ConfigurationManager.getInstance();

        // Initialize some devices
        SmartDevice device1 = new SmartDevice();
        SmartDevice device2 = new SmartDevice();

        // Print initial configuration
        System.out.println("Initial Configuration:");
        device1.printConfiguration();
        device2.printConfiguration();

        // Get new configuration settings from the user
        System.out.println("\nUpdate Configuration:");
        
        System.out.print("Enter new Network Settings: ");
        String newNetworkSettings = scanner.nextLine();
        config.setNetworkSettings(newNetworkSettings);

        System.out.print("Enter new User Preferences: ");
        String newUserPreferences = scanner.nextLine();
        config.setUserPreferences(newUserPreferences);

        System.out.print("Enter new System Mode: ");
        String newSystemMode = scanner.nextLine();
        config.setSystemMode(newSystemMode);

        // Print updated configuration
        System.out.println("\nUpdated Configuration:");
        device1.printConfiguration();
        device2.printConfiguration();

        scanner.close();
    }
}