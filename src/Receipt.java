import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Receipt {
    public Receipt(List<Dress> selectedDresses, List<Accessory> selectedAccessories) {
        // Create a new frame for the receipt preview
        JFrame receiptFrame = new JFrame("Receipt Preview");
        receiptFrame.setSize(500, 500);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel to display the receipt
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
        receiptPanel.setBackground(Color.WHITE);

        // Add a title section
        JLabel titleLabel = new JLabel("Boutique Receipt", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        receiptPanel.add(titleLabel);

        // Separator line
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.LIGHT_GRAY);
        receiptPanel.add(separator);

        // Display all selected dresses and accessories
        double totalPrice = 0;

        // Add dresses section
        JLabel dressesLabel = new JLabel("Dresses:");
        dressesLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        dressesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        receiptPanel.add(dressesLabel);

        for (Dress dress : selectedDresses) {
            JLabel dressLabel = new JLabel(dress.getName() + " - RM " + dress.getPrice());
            dressLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            receiptPanel.add(dressLabel);
            totalPrice += Double.parseDouble(dress.getPrice());
        }

        // Add accessories section
        JLabel accessoriesLabel = new JLabel("Accessories:");
        accessoriesLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        accessoriesLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        receiptPanel.add(accessoriesLabel);

        for (Accessory accessory : selectedAccessories) {
            JLabel accessoryLabel = new JLabel(accessory.getName() + " - RM " + accessory.getPrice());
            accessoryLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            receiptPanel.add(accessoryLabel);
            totalPrice += Double.parseDouble(accessory.getPrice());
        }

        // Add a total price section
        receiptPanel.add(Box.createVerticalStrut(10));
        JLabel totalPriceLabel = new JLabel("Total Price: RM " + String.format("%.2f", totalPrice));
        totalPriceLabel.setFont(new Font("Serif", Font.BOLD, 16));
        totalPriceLabel.setForeground(Color.BLACK);
        totalPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        receiptPanel.add(totalPriceLabel);

        // Add a back button
        JButton backButton = new JButton("Back to Login");
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receiptFrame.dispose();
                new LoginFrame(); // Open the login frame
            }
        });
        receiptPanel.add(Box.createVerticalStrut(20));
        receiptPanel.add(backButton);

        // Add padding and border
        receiptPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                new LineBorder(Color.LIGHT_GRAY, 1, true))
        );

        // Wrap the receipt panel in a scroll pane
        JScrollPane scrollPane = new JScrollPane(receiptPanel);
        scrollPane.setBorder(null);
        receiptFrame.add(scrollPane);

        // Make the frame visible
        receiptFrame.setVisible(true);
    }
}
