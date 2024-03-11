import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        StopRecordList stopRecords = new StopRecordList();
        stopRecords.loadRecords();

        double userX, userY;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your X coordinate: ");
        userX = scanner.nextDouble();
        System.out.print("Enter your Y coordinate: ");
        userY = scanner.nextDouble();
        scanner.close();

        stopRecords.sortByDistance(userX, userY);
        System.out.println("The 10 closest bus stops to your location are:");
        stopRecords.printFirst(10);
    }
}