import javax.swing.*;
import java.awt.*;

public class WeddingManagementSystem extends JFrame {

    // Constructor to set up the JFrame
    public WeddingManagementSystem() {
        // Set up JFrame properties
        setTitle("Wedding Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new CardLayout());

        // Home Panel
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(3, 1, 10, 10));
        JLabel welcomeLabel = new JLabel("Welcome to the Wedding Management System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        JButton venueButton = new JButton("Manage Venues");
        JButton guestButton = new JButton("Manage Guests");
        JButton summaryButton = new JButton("Generate Summary");

        homePanel.add(welcomeLabel);
        homePanel.add(venueButton);
        homePanel.add(guestButton);
        homePanel.add(summaryButton);

        // Venue Management Panel
        JPanel venuePanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel venueNameLabel = new JLabel("Venue Name:");
        JTextField venueNameField = new JTextField();
        JLabel venueCapacityLabel = new JLabel("Capacity:");
        JTextField venueCapacityField = new JTextField();
        JButton saveVenueButton = new JButton("Save Venue");
        JButton backToHomeFromVenue = new JButton("Back to Home");

        venuePanel.add(venueNameLabel);
        venuePanel.add(venueNameField);
        venuePanel.add(venueCapacityLabel);
        venuePanel.add(venueCapacityField);
        venuePanel.add(saveVenueButton);
        venuePanel.add(backToHomeFromVenue);

        // Guest Management Panel
        JPanel guestPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel guestNameLabel = new JLabel("Guest Name:");
        JTextField guestNameField = new JTextField();
        JLabel guestCountLabel = new JLabel("Guest Count:");
        JTextField guestCountField = new JTextField();
        JButton saveGuestButton = new JButton("Save Guest");
        JButton backToHomeFromGuest = new JButton("Back to Home");

        guestPanel.add(guestNameLabel);
        guestPanel.add(guestNameField);
        guestPanel.add(guestCountLabel);
        guestPanel.add(guestCountField);
        guestPanel.add(saveGuestButton);
        guestPanel.add(backToHomeFromGuest);

        // Summary Panel
        JPanel summaryPanel = new JPanel(new BorderLayout());
        JTextArea summaryTextArea = new JTextArea();
        JButton backToHomeFromSummary = new JButton("Back to Home");
        summaryPanel.add(new JScrollPane(summaryTextArea), BorderLayout.CENTER);
        summaryPanel.add(backToHomeFromSummary, BorderLayout.SOUTH);

        // Add Panels to Main Panel
        mainPanel.add(homePanel, "Home");
        mainPanel.add(venuePanel, "Venue");
        mainPanel.add(guestPanel, "Guest");
        mainPanel.add(summaryPanel, "Summary");

        // Add Main Panel to JFrame
        add(mainPanel);

        // Set up Card Layout
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        // Button Actions
        venueButton.addActionListener(e -> cardLayout.show(mainPanel, "Venue"));
        guestButton.addActionListener(e -> cardLayout.show(mainPanel, "Guest"));
        summaryButton.addActionListener(e -> {
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
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WeddingManagementSystem app = new WeddingManagementSystem();
            app.setVisible(true);
        });
    }
}
