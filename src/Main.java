/*This Main class will call for an instance of mainMenu() menu 
 * Driver class that will call needed functions
*/

class Main {
    private static final boolean console = true;
    public static void main(String[] args) {
        if (console)
            new ConsoleViewer();
        else
            new GraphicViewer();
    }
}