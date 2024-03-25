import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicViewer extends JFrame implements StopRecordTemplate {
    private StopRecordList stopRecordList;
    private BufferedImage mapImage;

    public GraphicViewer() {
        super("Bus Stop Graphic Viewer");
        stopRecordList = new StopRecordList();
        try {
            mapImage = ImageIO.read(new File("data/map.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMenu() {
        JLabel instructionsLabel = new JLabel("Click on the map to find the closest bus stops.");

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (mapImage != null)
                    g.drawImage(mapImage, 0, 0, this);
            }
        };

        mapPanel.setPreferredSize(new Dimension(mapImage.getWidth(), mapImage.getHeight()));
        mapPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Call a method to handle clicked coordinates and display closest bus stops
                handleMapClick(e.getX(), e.getY());
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(instructionsLabel, BorderLayout.NORTH);
        mainPanel.add(mapPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

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
    }
}
