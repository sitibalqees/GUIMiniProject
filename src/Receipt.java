import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Receipt {
    public Receipt(List<Dress> selectedDresses, List<Accessory> selectedAccessories, String customerName, String email, String phone) {
        // Create the frame
        JFrame receiptFrame = new JFrame("Receipt Preview");
        receiptFrame.setSize(1600, 800);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // Make the frame full screen
        receiptFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize to full screen
        receiptFrame.setUndecorated(false);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(255, 229, 204));

        // Top panel for customer information and "Home" button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 229, 204));

        // Customer information panel
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new GridLayout(4, 2, 5, 5));
        customerInfoPanel.setBackground(new Color(255, 229, 204));

        customerInfoPanel.add(new JLabel("Name:"));
        customerInfoPanel.add(new JLabel(customerName));
        customerInfoPanel.add(new JLabel("Email:"));
        customerInfoPanel.add(new JLabel(email));
        customerInfoPanel.add(new JLabel("Phone Number:"));
        customerInfoPanel.add(new JLabel(phone));
        customerInfoPanel.add(new JLabel("Date:"));
        customerInfoPanel.add(new JLabel(java.time.LocalDate.now().toString()));

        topPanel.add(customerInfoPanel, BorderLayout.CENTER);

        // "Home" button
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 14));
        homeButton.setBackground(new Color(255, 204, 153));
        homeButton.setFocusPainted(false);

        // Action listener for the "Home" button
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receiptFrame.dispose();
                new WeddingManagementSystem();
                JOptionPane.showMessageDialog(null, "Returning to Home...");
            }
        });

        // Panel to hold the button, aligned to the top-right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(255, 229, 204));
        buttonPanel.add(homeButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Table for items
        String[] columns = {"No", "Item Name", "Quantity", "Price", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable itemsTable = new JTable(tableModel);
        itemsTable.setFillsViewportHeight(true);
        itemsTable.setRowHeight(25);

        // Add items to the table
        int index = 1;
        double subtotal = 0.0;
        for (Dress dress : selectedDresses) {
            double price = Double.parseDouble(dress.getPrice());
            tableModel.addRow(new Object[]{index++, dress.getName(), 1, price, price});
            subtotal += price;
        }
        for (Accessory accessory : selectedAccessories) {
            double price = Double.parseDouble(accessory.getPrice());
            tableModel.addRow(new Object[]{index++, accessory.getName(), 1, price, price});
            subtotal += price;
        }

        JScrollPane tableScrollPane = new JScrollPane(itemsTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Summary panel
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new GridLayout(4, 2, 5, 5));
        summaryPanel.setBackground(new Color(255, 229, 204));

        double taxRate = 5; // 5% tax
        double tax = subtotal * taxRate / 100;
        double total = subtotal + tax;

        summaryPanel.add(new JLabel("Subtotal:"));
        summaryPanel.add(new JLabel(String.format("RM %.2f", subtotal)));
        summaryPanel.add(new JLabel("Tax (5%):"));
        summaryPanel.add(new JLabel(String.format("RM %.2f", tax)));
        summaryPanel.add(new JLabel("Total:"));
        summaryPanel.add(new JLabel(String.format("RM %.2f", total)));

        mainPanel.add(summaryPanel, BorderLayout.SOUTH);

        // Add main panel to the frame
        receiptFrame.add(mainPanel);

        // Set frame visibility
        receiptFrame.setVisible(true);
    }
}