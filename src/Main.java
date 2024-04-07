/**
 * The main driver class that will call for either the console or graphic viewer.
*/

public class Main {
    /**
     * Main method that will call for either the console or graphic viewer.
     * @param args command line arguments, "console" to run the console viewer
     */
    public static void main(String[] args) {
        boolean console = args.length > 0 && args[0].toLowerCase().equals("console");
        if (console)
            new ConsoleViewer();
        else
            new GraphicViewer();
    }
}