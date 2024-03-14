/*This class will allow the the user to enter their
 * coordinates and will then compare the coordiantes with
 * our data by utilzing the sortbydistance function
 */
import java.util.Scanner;

public class StopViewer {
    private StopRecordList stopRecordList;

    public StopViewer() {
        stopRecordList = new StopRecordList();
        stopRecordList.loadRecords(); // Load records when the StopViewer is initialized
    }

    // Method to prompt user for coordinates and print the 10 closest bus stops
    public void promptAndPrintClosestBusStops(Scanner scanner) {
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
        printClosestBusStops(x, y);
    }
    

    // Method to find and print the 10 closest bus stops to the given coordinates
    private void printClosestBusStops(double x, double y) {
        stopRecordList.sortByDistance(x, y); // Sort records by distance from the given coordinates
        stopRecordList.printFirst(10); // Print the first 10 records after sorting
    }
}
