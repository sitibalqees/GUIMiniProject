import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<Dress> selectedDresses;
    private List<Accessory> selectedAccessories;

    public Checkout(List<Dress> selectedDresses, List<Accessory> selectedAccessories) {
        this.selectedDresses = selectedDresses;
        this.selectedAccessories = selectedAccessories;

        // Create the main frame
        JFrame checkoutFrame = new JFrame("Checkout");
        checkoutFrame.setSize(800, 600); // Adjusted for a better layout
        checkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Left-hand side: Customer Information
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new BoxLayout(customerInfoPanel, BoxLayout.Y_AXIS));

        customerInfoPanel.add(new JLabel("Customer Information"));
        customerInfoPanel.add(Box.createVerticalStrut(10)); // Add spacing

        JTextField firstNameField = new JTextField(15);
        JTextField lastNameField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JTextField addressField = new JTextField(15);
        JTextField cityField = new JTextField(15);
        JTextField stateField = new JTextField(15);
        JTextField zipField = new JTextField(15);

        // Add fields to the panel
        customerInfoPanel.add(new JLabel("First Name:"));
        customerInfoPanel.add(firstNameField);
        customerInfoPanel.add(new JLabel("Last Name:"));
        customerInfoPanel.add(lastNameField);
        customerInfoPanel.add(new JLabel("Email:"));
        customerInfoPanel.add(emailField);
        customerInfoPanel.add(new JLabel("Phone:"));
        customerInfoPanel.add(phoneField);
        customerInfoPanel.add(new JLabel("Address:"));
        customerInfoPanel.add(addressField);
        customerInfoPanel.add(new JLabel("City:"));
        customerInfoPanel.add(cityField);
        customerInfoPanel.add(new JLabel("State:"));
        customerInfoPanel.add(stateField);
        customerInfoPanel.add(new JLabel("ZIP Code:"));
        customerInfoPanel.add(zipField);

        // Save Button
        JButton saveButton = new JButton("Save Information");
        saveButton.addActionListener(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer_info.txt"))) {
                writer.write("First Name: " + firstNameField.getText() + "\n");
                writer.write("Last Name: " + lastNameField.getText() + "\n");
                writer.write("Email: " + emailField.getText() + "\n");
                writer.write("Phone: " + phoneField.getText() + "\n");
                writer.write("Address: " + addressField.getText() + "\n");
                writer.write("City: " + cityField.getText() + "\n");
                writer.write("State: " + stateField.getText() + "\n");
                writer.write("ZIP Code: " + zipField.getText() + "\n");
                writer.write("========================================================================================");
                JOptionPane.showMessageDialog(checkoutFrame, "Customer information saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(checkoutFrame, "Error saving information: " + ex.getMessage());
            }
        });
        customerInfoPanel.add(saveButton);

        // Add padding
        customerInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Selected Dresses and Accessories
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.add(new JLabel("Selected Dresses and Accessories"));
        itemsPanel.setFont(new Font("Felix Titling", Font.BOLD, 25));
        itemsPanel.add(Box.createVerticalStrut(10)); // Add spacing
        Font itemFont = new Font("Serif", Font.PLAIN, 20);

        // Add Dresses
        for (Dress dress : selectedDresses) {
            JPanel dressPanel = new JPanel();
            dressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel dressLabel = new JLabel(dress.getName() + " - RM " + dress.getPrice());
            dressLabel.setFont(itemFont);
            dressPanel.add(dressLabel);

            try {
                ImageIcon icon = new ImageIcon(dress.getImagePath());
                Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                dressPanel.add(new JLabel(new ImageIcon(scaledImage)));
            } catch (Exception e) {
                dressPanel.add(new JLabel("Image not available"));
            }
            itemsPanel.add(dressPanel);
        }

        // Add Accessories
        for (Accessory accessory : selectedAccessories) {
            JPanel accessoryPanel = new JPanel();
            accessoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel accessoryLabel = new JLabel(accessory.getName() + " - RM " + accessory.getPrice());
            accessoryLabel.setFont(itemFont);
            accessoryPanel.add(accessoryLabel);

            try {
                ImageIcon icon = new ImageIcon(accessory.getImagePath());
                Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                accessoryPanel.add(new JLabel(new ImageIcon(scaledImage)));
            } catch (Exception e) {
                accessoryPanel.add(new JLabel("Image not available"));
            }
            itemsPanel.add(accessoryPanel);
        }

        // Add padding
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Split the layout into two panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, customerInfoPanel, new JScrollPane(itemsPanel));
        splitPane.setDividerLocation(400); // Set the divider position

        // Create a button to preview the receipt
        JButton previewButton = new JButton("Preview Receipt");
        previewButton.addActionListener(e -> {
            new Receipt(selectedDresses, selectedAccessories);
        });

        // Add the preview button to the frame
        JPanel buttonPreview = new JPanel();
        buttonPreview.add(previewButton);
        checkoutFrame.add(buttonPreview, BorderLayout.SOUTH);

        // Create a Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            checkoutFrame.dispose(); // Close the Checkout frame
            new Accessories((ArrayList<Dress>) selectedDresses); // Open the Accessories frame
        });

        // Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(previewButton);
        checkoutFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Add the split pane to the frame
        checkoutFrame.add(splitPane);
        checkoutFrame.setVisible(true);
    }
}
