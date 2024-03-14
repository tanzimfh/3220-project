/*This Main class will call for an instance of mainMenu() menu 
 * Driver class that will call needed functions
*/

class Main {
    public static void main(String[] args) {
        mainMenu menu = new mainMenu(); // Instantiate the mainMenu object
        menu.displayMenu();
    }
}