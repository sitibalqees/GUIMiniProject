import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DressCatalogI extends JFrame{
    private ArrayList<Dress> selectedDressesI = new ArrayList<>();
    private ArrayList<Accessory> selectedAccessories = new ArrayList<>();

    public DressCatalogI() {
        JFrame frame = new JFrame("Dress Catalog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 800);

        // Main frame layout
        frame.setLayout(new BorderLayout());

        // Make the frame full screen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize to full screen
        frame.setUndecorated(false);

        // Add a title at the top
        JLabel titleLabel = new JLabel("Dress Catalog", JLabel.CENTER);
        titleLabel.setFont(new Font("Felix Titling", Font.BOLD, 60));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add spacing
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel for dresses with flexible layout
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gridPanel.setBackground(new Color(255, 229, 204)); // Beige background

        // Example data for dresses (name, price, image path)
        String[][] dressData = {
                {"Bride And Baraat Cherry Red Fully Embroidered Lavish Lahengga ", "7331.00", "Dress/CherryLahengga.png"},
                {"Bloom Pink Bridal Lahengga In Raw Silk With Hand Embroidery", "15525.00", "Dress/BloomPinkLahengga.png"},
                {"Yellow Embroidered Bridal Lahengga and Blouse Set with Mirror Work", "6026.00", "Dress/YellowLahengga.png"},
                {"Dark Blue Embroidered Gown With Wings", "2921.00", "Dress/DarkBlueGown.png"},
                {"Poseidon Teal Circular Flared Gown With Fancy Sleeves", "3101.00", "Dress/TealGown.png"},
                {"Beige Heavy Embroidered Gown With Jacket", "18896.00", "Dress/BeigeGown.png"},
                {"Beige Paisely Printed Sherwani With Resham Work For Men", "1121.00", "Dress/BeigePaisely.png"},
                {"Peach Silk Jodhpuri Suit", "1188.00", "Dress/peachSilk.png"},
                {"Yellow Foil Printed Kurta Jacket Set For Men", "581.00", "Dress/YellowKurta.png"}
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
            decrementButton.setBackground(new Color(255,128,0));
            JButton incrementButton = new JButton("+");
            incrementButton.setBackground(new Color(255,128,0));
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
            addButton.setBackground(new Color(255,128,0));
            addButton.addActionListener(e -> {
                int quantity = Integer.parseInt(quantityField.getText());
                if (quantity > 0) {
                    Dress selectedDress = new Dress(dress[0], dress[1], quantity , dress[2]);
                    selectedDressesI.add(selectedDress);
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
        backButton.setBackground(new Color(255,128,0));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            // Implement navigation logic for Back button (go back to the previous frame)
            frame.dispose(); // Close the current frame
            new WeddingManagementSystem(); // Open the previous screen (or desired frame)
        });
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.setBackground(new Color(255, 229, 204)); // Beige background

        // Add the "Next" button on the right
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBackground(new Color(255,128,0));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> {
            new Accessories(selectedDressesI);
            this.dispose(); // Close the current frame
        });
        topPanel.add(nextButton, BorderLayout.EAST);

        // Add the panel containing both buttons to the top (NORTH) region of the frame
        frame.add(topPanel, BorderLayout.NORTH);

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DressCatalogI();
    }
}