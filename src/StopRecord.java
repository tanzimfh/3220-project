/*This class will create a hashmap that will store x, y, coordinates and the name
 * of each stop and provide a string that will format each one  
 * approperitely
  */
import java.util.HashMap;
import java.util.StringTokenizer;

public class StopRecord implements StopRecordTemplate {
    public HashMap<String, String> recordMap;
    public double xCoord, yCoord;
    public String location;

    public StopRecord(String line) {
        recordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(line, DELIMITER);
        for (int i = 0; i < FIELD_LABELS.length; i++) {
            recordMap.put(FIELD_LABELS[i], st.nextToken());
        }
        xCoord = Double.parseDouble(recordMap.get(FIELD_LABELS[XCOORD_INDEX]));
        yCoord = Double.parseDouble(recordMap.get(FIELD_LABELS[YCOORD_INDEX]));
        location = recordMap.get(FIELD_LABELS[STREE_ON_INDEX]) + " at " + recordMap.get(FIELD_LABELS[STREET_AT_INDEX]);
    }

    public String toString(){
        return String.format("%-15f %-15f %-45s", xCoord, yCoord, location);
    }
}
