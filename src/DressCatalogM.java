import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DressCatalogM extends JFrame {
    public DressCatalogM() {
        JFrame frame = new JFrame("Dress Catalog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Larger frame size for better layout

        // Main frame layout
        frame.setLayout(new BorderLayout());

        // Add a title at the top
        JLabel titleLabel = new JLabel("Dress Catalog", JLabel.CENTER);
        titleLabel.setFont(new Font("Felix Titling", Font.BOLD, 60));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add spacing
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel for dresses with flexible layout
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Example data for dresses (name, price, image path)
        String[][] dressData = {
                {"Aishah - Baju Nikah Kurung Riau ", "600.00", "KurungRiau.png"},
                {"Sabariah - Kebaya Songket Mint Green and Gold", "800.00", "KebayaSongket.png"},
                {"Bella Diane - Baby Blue Songket Two-Piece", "800.00", "BlueSongket.png"},
                {"Cempaka - Baju Nikah kurung Riau", "600.00", "Cempaka.png"},
                {"Pauline - Tulip Dress,Songket Off White and Silver ", "600.00", "Pauline.png"},
                {"Maharani I - Loose Dress with Detachable Cape,Off White ", "600.00", "Maharani.png"},
                {"Emelda Sari - Songket Emerald Green and Brown", "800.00", "EmeldaSari.png"},
                {"Creamy Bali - Cream,Light Brown and Light Grey Songket ", "800.00", "creamyBali.png"},
                {"Benafe - Songket Royal Blue Silver", "800.00", "Benafe.png"}
        };

        // Loop to create each item in the grid
        for (String[] dress : dressData) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            panel.setBackground(Color.WHITE);

            // Add dress image
            JLabel dressImage;
            try {
                // Load and scale the image
                ImageIcon icon = new ImageIcon(dress[2]);
                Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                dressImage = new JLabel(new ImageIcon(scaledImage));
            } catch (Exception e) {
                // Placeholder if image is not found
                dressImage = new JLabel("Image Not Found", JLabel.CENTER);
                dressImage.setPreferredSize(new Dimension(200, 200));
                dressImage.setHorizontalAlignment(JLabel.CENTER);
            }
            dressImage.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Add name and price
            JLabel dressName = new JLabel(dress[0], JLabel.CENTER); // Center alignment
            dressName.setAlignmentX(Component.CENTER_ALIGNMENT);    // Align in the box layout
            dressName.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel dressPrice = new JLabel("Price: RM " + dress[1], JLabel.CENTER );
            dressPrice.setAlignmentX(Component.CENTER_ALIGNMENT);   // Align in the box layout
            dressPrice.setFont(new Font("Arial", Font.PLAIN, 16));

            // Quantity panel with increment/decrement buttons
            JPanel quantityPanel = new JPanel();
            JButton decrementButton = new JButton("-");
            JButton incrementButton = new JButton("+");
            JTextField quantityField = new JTextField("0", 3);
            quantityField.setHorizontalAlignment(JTextField.CENTER);

            decrementButton.addActionListener(e -> {
                int currentQuantity = Integer.parseInt(quantityField.getText());
                if (currentQuantity > 0) {
                    quantityField.setText(String.valueOf(currentQuantity - 1));
                }
            });

            incrementButton.addActionListener(e -> {
                int currentQuantity = Integer.parseInt(quantityField.getText());
                quantityField.setText(String.valueOf(currentQuantity + 1));
            });

            // Add components to quantity panel
            quantityPanel.add(decrementButton);
            quantityPanel.add(quantityField);
            quantityPanel.add(incrementButton);

            // Add everything to the main panel
            panel.add(dressImage);
            panel.add(dressName);
            panel.add(dressPrice);
            panel.add(quantityPanel);

            // Add panel to grid
            gridPanel.add(panel);
        }

        // Add grid panel to the center
        frame.add(new JScrollPane(gridPanel), BorderLayout.CENTER);

        // Add a "Checkout" button at the bottom
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 20));
        checkoutButton.setBackground(Color.GREEN);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFocusPainted(false);
        checkoutButton.addActionListener(e -> new Accessories());

        // Add button to the frame
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkoutButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }

    public static void main (String[] args){
        DressCatalogM Malay = new DressCatalogM();
    }

}

