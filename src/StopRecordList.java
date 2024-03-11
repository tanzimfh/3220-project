import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StopRecordList implements StopRecordTemplate {
    public ArrayList<StopRecord> recordList;

    public StopRecordList() {
        recordList = new ArrayList<>();
    }

    public StopRecord get(int i) {
        return recordList.get(i);
    }

    public int loadRecords() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                recordList.add(new StopRecord(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return recordList.size();
    }

    public void sortByDistance(double x, double y) {
        recordList.sort((a, b) -> {
            return Double.compare(
                Math.pow(a.xCoord - x, 2) + Math.pow(a.yCoord - y, 2),
                Math.pow(b.xCoord - x, 2) + Math.pow(b.yCoord - y, 2));
        });
    }

    public void printFirst(int n) {
        System.out.printf("%-15s %-15s %-45s\n", "XCoord", "YCoord", "Location");
        
        for (int i = 0; i < n; i++) {
            System.out.println(recordList.get(i));
        }
    }
}