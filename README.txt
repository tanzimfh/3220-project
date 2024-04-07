This is the source code for Team 10's project in COMP 3220 Winter 2024.

A brief explanation of each file:
data/
    map.png: an image of the map of the City of Windsor
    stops.csv: data file from the City of Windsor open data source containing information about bus stops
docs/
    class_diagram.png: UML class diagram of an older state of the code
    sequence_diagram.png: UML sequence diagram for displaying the closest stops using the console viewer
src/
    ConsoleViewer.java: shows a console menu that lets the user input coordinates and see the closest bus stops
    GraphicViewer.java: shows the map and displays the closest bus stops to mouse clicks
    Main.java: creates a console or graphic viewer based on the command line argument
    StopRecord.java: stores coordinates and location of a bus stop
    StopRecordList.java: parses the data file and stores info about bus stops
    StopRecordTemplate.java: defines the structure of the data files