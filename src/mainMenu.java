import java.util.Scanner;

public class mainMenu {
    private StopViewer stopViewer; // Declare StopViewer object
    private Scanner scanner; // Declare Scanner object

    public mainMenu() {
        stopViewer = new StopViewer(); // Initialize StopViewer object
        scanner = new Scanner(System.in); // Initialize Scanner object
    }

    public void displayMenu() {
        char choice = ' '; // Initialize choice

        while (choice != 'E') {
            System.out.println("Welcome to the Bus Service Menu:");
            System.out.println("C - Closest Bus Stops");
            System.out.println("P - Plan a Trip (Not implemented yet)");
            System.out.println("E - Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = scanner.nextLine().toUpperCase().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please try again.");
                continue; // Skip the rest of the loop and start a new iteration
            }

            switch (choice) {
                case 'C':
                    stopViewer.promptAndPrintClosestBusStops(scanner);
                    break;
                case 'P':
                    // Call the plan trip function here
                    break;
                case 'E':
                    System.out.println("Exiting the menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close(); // Close the Scanner
    }
}
