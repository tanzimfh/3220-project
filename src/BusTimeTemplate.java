/*Used to read our file/data */
interface BusTimeTemplate {
    public static final String FILE_NAME = "data/stop_times.txt";
    public static final String DELIMITER = ",";
    public static final String[] FIELD_LABELS = {
            "trip_id", "arrive_time", "departure_time", "stop_id", "stop_sequence", "stop_headsign", "pickup_type", "drop_off_type"};
    public static final int arrivalTime = 1, departureTime = 2;
    public static final int stopID = 3;
}
