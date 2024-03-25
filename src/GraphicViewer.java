import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicViewer extends JFrame {

    public GraphicViewer() {
        super("Bus Stop Graphic Viewer");
    }

    public void displayMenu() {
        JLabel instructionsLabel = new JLabel("Click on the map to find the closest bus stops.");

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the map here
                
            }
        };

        mapPanel.setPreferredSize(new Dimension(400, 300));
        mapPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // Call a method to handle clicked coordinates and display closest bus stops
                handleMapClicks(x, y);
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

    private void handleMapClicks(int x, int y) {
        // Implement the logic to handle map clicks and display closest bus stops here
        // You can utilize the methods from consoleViewer class to find the closest bus stops
    }
}
