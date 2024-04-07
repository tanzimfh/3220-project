import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class reads the data file and store the bus stops in a list.
 */
public class StopRecordList implements StopRecordTemplate {
    private ArrayList<StopRecord> recordList;

    /**
     * Constructor that initializes the list of bus stops and loads data from the file.
     */
    public StopRecordList() {
        recordList = new ArrayList<>();
        loadRecords();
    }

    /**
     * Reads the data file and stores the bus stops in the list.
     * @return the number of bus stops read
     */
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

    /**
     * Sorts the list of bus stops by distance from a given point.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public void sortByDistance(double x, double y) {
        recordList.sort((a, b) -> {
            return Double.compare(
                Math.pow(a.getX() - x, 2) + Math.pow(a.getY() - y, 2),
                Math.pow(b.getX() - x, 2) + Math.pow(b.getY() - y, 2));
        });
    }

    /**
     * Returns the first n bus stops in the list.
     * @param n the number of bus stops to return
     * @return an array of the first n bus stops
     */
    public StopRecord[] getFirst(int n) {
        n = Math.min(Math.max(n, 0), recordList.size());
        StopRecord[] records = new StopRecord[n];
        for (int i = 0; i < n; i++)
            records[i] = recordList.get(i);
        return records;
    }
}
