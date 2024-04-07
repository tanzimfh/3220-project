import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This class stores information about a bus stop.
 * Stores x and y coordinates and the name of the stop
 * and provides methods to access this information.
*/
public class StopRecord implements StopRecordTemplate {
    private HashMap<String, String> recordMap;
    private double xCoord, yCoord;
    private String location;

    /**
     * Constructor parses a valid line of information to store the x and y coordinates
     * and the name of the stop.
     * @param line the line to parse, must follow the format defined in StopRecordTemplate
     */
    public StopRecord(String line) {
        recordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(line, DELIMITER);
        for (int i = 0; i < FIELD_LABELS.length; i++) {
            recordMap.put(FIELD_LABELS[i], st.nextToken());
        }
        xCoord = Double.parseDouble(recordMap.get(FIELD_LABELS[XCOORD_INDEX]));
        yCoord = Double.parseDouble(recordMap.get(FIELD_LABELS[YCOORD_INDEX]));
        location = recordMap.get(FIELD_LABELS[STREET_ON_INDEX]) + " at " + recordMap.get(FIELD_LABELS[STREET_AT_INDEX]);
    }

    /**
     * Returns a string that formats the x and y coordinates and the name of the stop.
     * @return the formatted string
     */
    public String toString(){
        return String.format("%-15f %-15f %-45s", xCoord, yCoord, location);
    }

    /**
     * Returns the x coordinate of the stop.
     * @return the x coordinate
    */
    public double getX() { return xCoord; }

    /**
     * Returns the y coordinate of the stop.
     * @return the y coordinate
    */
    public double getY() { return yCoord; }
}
