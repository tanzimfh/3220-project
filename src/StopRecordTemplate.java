/**
 * Template that defines the structure of the data files.
 * */
interface StopRecordTemplate {
    /** name of the data file to read */
    public static final String FILE_NAME = "data/stops.csv";
    /** delimiter used to separate fields */
    public static final String DELIMITER = ",";
    /** labels for each field */
    public static final String[] FIELD_LABELS = {
            "XCoord", "YCoord", "FID", "BUS_ORIENT", "ON_STREET", "AT_STREET", "LOCATION_O", "LOCATION_A", "SHELTER",
            "BENCH", "GARBAGE", "LATITUDE", "LONGITUDE", "PUBLIC_ID", "ROUTE1", "ROUTE2", "ROUTE3", "ROUTE4", "ROUTE5",
            "ROUTE1DIRE", "ROUTE2DIRE", "ROUTE3DIRE", "ROUTE4DIRE", "ROUTE5DIRE", "ROUTE6", "ROUTE6DIRE" };
    /** index of the coordinate */
    public static final int XCOORD_INDEX = 0, YCOORD_INDEX = 1;
    /** index of the street name */
    public static final int STREET_ON_INDEX = 4, STREET_AT_INDEX = 5;

    /** coordinate of each corner of the map image */
    public static final double TOP_LEFT_Y = 42.346362, TOP_LEFT_X = -83.154947, BOT_RIGHT_Y = 42.198410, BOT_RIGHT_X = -82.792195;
    /** length and width of the map image in degrees */
    public static final double DELTA_Y = TOP_LEFT_Y - BOT_RIGHT_Y, DELTA_X = BOT_RIGHT_X - TOP_LEFT_X;
}
