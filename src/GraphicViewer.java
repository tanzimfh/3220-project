import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class will create a graphical interface for the user to navigate.
 * Will respond to user clicks on the map by displaying the closest bus stops.
 * Allows the user to change the number of closest bus stops to display.
 */
public class GraphicViewer extends JFrame implements StopRecordTemplate {
    private StopRecordList stopRecordList;
    private BufferedImage mapImage;
    private StopRecord[] closestStops;
    private int closest_num = 10;
    private JLabel numLabel;

    /**
     * Constructor that initializes member variables and shows the graphic viewer.
     */
    public GraphicViewer() {
        super("Bus Stop Graphic Viewer");
        stopRecordList = new StopRecordList();
        closestStops = new StopRecord[0];
        numLabel = new JLabel("Closest Stops: " + closest_num);
        try {
            mapImage = ImageIO.read(new File("data/map.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        display();
    }

    /**
     * Displays the graphic viewer with the map and buttons to edit number of closest stops.
     */
    public void display() {
        // Panel to hold the closest number controls
        JPanel numPanel = new JPanel();
        JButton tenMinusButton = new JButton("-10");
        tenMinusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closest_num = Math.max(1, closest_num - 10);
                updateNumLabel();
            }
        });
        JButton minusButton = new JButton("-1");
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closest_num = Math.max(1, closest_num - 1);
                updateNumLabel();
            }
        });
        JButton plusButton = new JButton("+1");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closest_num++;
                updateNumLabel();
            }
        });
        JButton tenPlusButton = new JButton("+10");
        tenPlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closest_num += 10;
                updateNumLabel();
            }
        });
        numPanel.add(tenMinusButton);
        numPanel.add(minusButton);
        numPanel.add(numLabel);
        numPanel.add(plusButton);
        numPanel.add(tenPlusButton);

        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(mapImage, 0, 0, this);
                drawClosestStops(g);
            }
        };

        mapPanel.setPreferredSize(new Dimension(mapImage.getWidth(), mapImage.getHeight()));
        mapPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Call a method to handle clicked coordinates and display closest bus stops
                handleMapClick(e.getX(), e.getY());
                mapPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(mapPanel, BorderLayout.CENTER);
        mainPanel.add(numPanel, BorderLayout.NORTH); // Add numPanel to the top

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void handleMapClick(int mouse_x, int mouse_y) {
        // convert mouse_x and mouse_y to latitude and longitude
        double x = TOP_LEFT_X + DELTA_X * mouse_x / mapImage.getWidth();
        double y = TOP_LEFT_Y - DELTA_Y * mouse_y / mapImage.getHeight();
        stopRecordList.sortByDistance(x, y);
        closestStops = stopRecordList.getFirst(closest_num);
    }

    private void drawClosestStops(Graphics g) {
        g.setColor(Color.RED);
        for (StopRecord record : closestStops) {
            int x = (int) ((record.getX() - TOP_LEFT_X) * mapImage.getWidth() / DELTA_X);
            int y = (int) ((TOP_LEFT_Y - record.getY()) * mapImage.getHeight() / DELTA_Y);
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    private void updateNumLabel() {
        numLabel.setText("Closest Stops: " + closest_num);
    }
}
