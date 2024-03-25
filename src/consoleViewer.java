/*This class will create a menu interface for the user to navigate
 * will prompt user to enter selection and based on selection
 * it will call a function that is related to the respective function
 */
import java.util.Scanner;

public class consoleViewer {
    private Scanner scanner; // Declare Scanner object
    private StopRecordList stopRecordList;

    public consoleViewer() {
        scanner = new Scanner(System.in); // Initialize Scanner object
        stopRecordList = new StopRecordList(); // Initialize StopRecordList object
        stopRecordList.loadRecords(); // Load records when the mainMenu is initialized
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
                    closestStops();
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

    private void closestStops() {
        double x = 0.0, y = 0.0;
        boolean validInput = false;
    
        while (!validInput) {
            System.out.print("Enter your coordinates (x, y): ");
            String inputLine = scanner.nextLine();
            String[] input = inputLine.split(",\\s*");
    
            if (input.length == 2) {
                try {
                    x = Double.parseDouble(input[0]);
                    y = Double.parseDouble(input[1]);
                    validInput = true; // Proper format and parsing successful, break loop
                } catch (NumberFormatException e) {
                    // Input was not a valid double
                    System.out.println("Invalid input. Please enter numeric coordinates in the format 'x, y'. For example, '-82.0002, 40.4534'.");
                }
            } else {
                System.out.println("Invalid input. Please enter coordinates in the format 'x, y'. For example, '-82.0002, 40.4534'.");
            }
        }
    
        System.out.println("Closest Bus Stops to Coordinates (" + x + ", " + y + "):");
        stopRecordList.sortByDistance(x, y); // Sort records by distance from the given coordinates
        System.out.printf("%-15s %-15s %-45s\n", "XCoord", "YCoord", "Location"); // Print table headers
        for (StopRecord record : stopRecordList.getFirst(10))   // Print the first 10 records
            System.out.println(record);
    }
}
