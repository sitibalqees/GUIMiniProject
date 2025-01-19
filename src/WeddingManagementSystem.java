import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeddingManagementSystem extends JFrame {

    // Constructor to set up the JFrame
    public WeddingManagementSystem() {
        // Set up JFrame properties
        setTitle("Home Screen");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Background Panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("boutique2.jpg"); // Replace with your image path
                if (backgroundImage.getImageLoadStatus() == MediaTracker.COMPLETE) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.WHITE);
                    g.drawString("Background image not found", 20, 20);
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout()); // Set layout for background panel

        // Header panel for the title
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setOpaque(false); // Make the header panel transparent
        JLabel welcomeLabel = new JLabel("Welcome to The Wedding System Management");
        welcomeLabel.setFont(new Font("Felix Titling", Font.BOLD, 40)); // Customize font
        welcomeLabel.setForeground(Color.WHITE); // Text color
        headerPanel.add(welcomeLabel);

        // Content panel with GridLayout for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200)); // Add padding around the grid

        // Create buttons
        JButton malayPackage = new JButton("MALAY PACKAGE");
        JButton chinesePackage = new JButton("CHINESE PACKAGE");
        JButton indianPackage = new JButton("INDIAN PACKAGE");
        JButton westernPackage = new JButton("WESTERN PACKAGE");
        JButton services = new JButton("SERVICES");
        JButton logoutButton = new JButton("Log Out");

        // Create and assign a single ButtonHandler instance
        ButtonHandler handler = new ButtonHandler();

        malayPackage.addActionListener(handler);
        chinesePackage.addActionListener(handler);
        indianPackage.addActionListener(handler);
        westernPackage.addActionListener(handler);
        services.addActionListener(handler);
        logoutButton.addActionListener(handler);

        // Add buttons to the grid
        buttonPanel.add(malayPackage);
        buttonPanel.add(chinesePackage);
        buttonPanel.add(indianPackage);
        buttonPanel.add(westernPackage);
        buttonPanel.add(services);
        buttonPanel.add(logoutButton);

        // Add panels to the background panel
        backgroundPanel.add(headerPanel, BorderLayout.NORTH); // Header at the top
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER); // Buttons in the center

        // Add the background panel to the frame
        setContentPane(backgroundPanel);

        setVisible(true);
    }

    // ButtonHandler class to handle button actions
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "MALAY PACKAGE":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Malay Package Selected");
                    new DressCatalogM();
                    break;

                case "CHINESE PACKAGE":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Chinese Package Selected");
                    new DressCatalogC();
                    break;

                case "INDIAN PACKAGE":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Indian Package Selected");
                    new DressCatalogI();
                    break;

                case "WESTERN PACKAGE":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Western Package Selected");
                    new DressCatalogW();
                    break;

                case "SERVICES":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Services Selected");
                    break;

                case "Log Out":
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Logging Out...");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(WeddingManagementSystem.this, "Unknown Action");
            }
        }
    }


    public static void main(String[] args) {
        WeddingManagementSystem app = new WeddingManagementSystem();
    }
}







