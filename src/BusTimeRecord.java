/*This class will create a hashmap that will store x, y, coordinates and the name
 * of each stop and provide a string that will format each one 
 * approperitely
  */
import java.util.HashMap;
import java.util.StringTokenizer;

public class BusTimeRecord implements BusTimeTemplate {
    public HashMap<String, String> recordMap;
    public double arrival, departure;
    public String stopIDs;

    public BusTimeRecord(String line) {
        recordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(line, DELIMITER);
        for (int i = 0; i < FIELD_LABELS.length; i++) {
            recordMap.put(FIELD_LABELS[i], st.nextToken());
        }
        arrival = Double.parseDouble(recordMap.get(FIELD_LABELS[arrivalTime]));
        departure = Double.parseDouble(recordMap.get(FIELD_LABELS[departureTime]));
        stopIDs = recordMap.get(FIELD_LABELS[stopID]);
    }
    public String toString(){
        return String.format("%-15f %-15f %-45s", stopIDs, arrival, departure);
    }
}
