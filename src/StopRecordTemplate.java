/*Used to read our file/data */
interface StopRecordTemplate {
    public static final String FILE_NAME = "data/stops.csv";
    public static final String DELIMITER = ",";
    public static final String[] FIELD_LABELS = {
            "XCoord", "YCoord", "FID", "BUS_ORIENT", "ON_STREET", "AT_STREET", "LOCATION_O", "LOCATION_A", "SHELTER",
            "BENCH", "GARBAGE", "LATITUDE", "LONGITUDE", "PUBLIC_ID", "ROUTE1", "ROUTE2", "ROUTE3", "ROUTE4", "ROUTE5",
            "ROUTE1DIRE", "ROUTE2DIRE", "ROUTE3DIRE", "ROUTE4DIRE", "ROUTE5DIRE", "ROUTE6", "ROUTE6DIRE" };
    public static final int XCOORD_INDEX = 0, YCOORD_INDEX = 1;
    public static final int STREE_ON_INDEX = 4, STREET_AT_INDEX = 5;
}
