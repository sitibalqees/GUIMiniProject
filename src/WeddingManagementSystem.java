import javax.swing.*;
import java.awt.*;

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
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout()); // Set layout for background panel

        // Header panel for the title
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setOpaque(false); // Make the header panel transparent
        JLabel welcomeLabel = new JLabel("Welcome to The Wedding System Management");
        welcomeLabel.setFont(new Font("Felix Titling", Font.BOLD, 40)); // Customize font
        welcomeLabel.setForeground(Color.white); // Text color
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

        // Add buttons to the grid
        buttonPanel.add(malayPackage);
        buttonPanel.add(chinesePackage);
        buttonPanel.add(indianPackage);
        buttonPanel.add(westernPackage);
        buttonPanel.add(services);
        buttonPanel.add(logoutButton);

        // Add panels to the background panel
        backgroundPanel.add(headerPanel, BorderLayout.NORTH); // Header at the top
        backgroundPanel.add(buttonPanel, BorderLayout.EAST); // Buttons in the center

        // Add the background panel to the frame
        setContentPane(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        WeddingManagementSystem app = new WeddingManagementSystem();
    }
}






        /*/ Button Actions
        malayPackage.addActionListener(e -> cardLayout.show(mainPanel, "Venue"));
        chinesePackage.addActionListener(e -> cardLayout.show(mainPanel, "Guest"));
        indianPackage.addActionListener(e -> {
            summaryTextArea.setText("Summary of Data:\n");
            // Placeholder for real data logic
            summaryTextArea.append("Venue Details and Guest List will go here.\n");
            cardLayout.show(mainPanel, "Summary");
        });

        saveVenueButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Venue Saved!"));
        saveGuestButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Guest Saved!"));

        backToHomeFromVenue.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        backToHomeFromGuest.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        backToHomeFromSummary.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
    }*/



