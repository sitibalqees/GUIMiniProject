import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DressCatalogC extends JFrame {
    private ArrayList<Dress> selectedDresses = new ArrayList<>();
    private ArrayList<Accessory> selectedAccessories = new ArrayList<>();

    public DressCatalogC(){
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
                {"White Cheongsam Qipao ", "845.00", "Dress/Qipao.png"},
                {"Jade Bespoke Dress [Mermaid]", "3,970.00", "Dress/JadeDress.png"},
                {"Sahra Bespoke Jumpsuit | Modern Vietnamese Chinese", "2.964.00", "Dress/SahraJumpsuit.png"},
                {"Phoebe Bespoke Dress | Traditional Wedding Dress", "2,964.00", "Dress/PhoebeDress.png"},
                {"Mindy Bespoke Dress | Red & Gold Chinese", "3,970.00", "Dress/Mindy.png"},
                {"Kelly Bespoke Dress | Modern Vietnamese Wedding Dress", "2,964.00", "Dress/kellyDress.png"},
                {"Wedding Qun Kwa Dress and Tang Suit | Golden Couple", "1,925.00", "Dress/GoldenCouple.png"},
                {"Traditional Vietnamese Ao Dai", "187.00", "Dress/AoDai.png"},
                {"Chinese Mandarin Tang Jacket (Black) | Spring", "336.00", "Dress/TangJacket.png"}
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
                Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Larger image
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
            JLabel dressPrice = new JLabel("Price: RM " + dress[1], JLabel.CENTER);
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

            // Store dress data when quantity is greater than 0
            JButton addButton = new JButton("Add to Cart");
            addButton.addActionListener(e -> {
                int quantity = Integer.parseInt(quantityField.getText());
                if (quantity > 0) {
                    Dress selectedDress = new Dress(dress[0], dress[1], quantity,dress[2]);
                    selectedDresses.add(selectedDress);
                    JOptionPane.showMessageDialog(frame, dress[0] + " added to cart.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a quantity.");
                }
            });
            panel.add(addButton);

            // Add panel to grid
            gridPanel.add(panel);
        }

        // Add grid panel to the center
        frame.add(new JScrollPane(gridPanel), BorderLayout.CENTER);

        // Create a panel for both "Back" and "Next" buttons at the top
        JPanel topPanel = new JPanel(new BorderLayout());

        // Add the "Back" button on the left
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.GREEN);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            // Implement navigation logic for Back button (go back to the previous frame)
            frame.dispose(); // Close the current frame
            new WeddingManagementSystem(); // Open the previous screen (or desired frame)
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // Add the "Next" button on the right
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBackground(Color.GREEN);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> new Accessories(selectedDresses)); // Navigate to Accessories frame
        topPanel.add(nextButton, BorderLayout.EAST);

        // Add the panel containing both buttons to the top (NORTH) region of the frame
        frame.add(topPanel, BorderLayout.NORTH);

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DressCatalogC();
    }
}
