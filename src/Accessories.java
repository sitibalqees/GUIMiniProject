import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Accessories extends JFrame {

    private JButton btnHairpiece, btnNecklace, btnShoes, btnBracelet, btnVeil, btnEaring;
    private JPanel detailsPanel;

    // Lists of accessories
    private ArrayList<Accessory> hairpieceList;
    private ArrayList<Accessory> necklaceList;
    private ArrayList<Accessory> shoesList;
    private ArrayList<Accessory> braceletList;
    private ArrayList<Accessory> veilList;
    private ArrayList<Accessory> earingList;

    // Constructor
    public Accessories() {
        super.setTitle("ACCESSORIES");
        super.setSize(800, 600); // Adjust size to fit content better
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Title label
        JLabel titleLabel = new JLabel("ACCESSORIES", JLabel.CENTER);
        titleLabel.setFont(new Font("Felix Titling", Font.BOLD, 40));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Padding for title
        add(titleLabel, BorderLayout.NORTH);

        // Initialize accessory lists
        initializeAccessoryLists();

        // Prepare the main content panel
        prepareAccessoriesPanel();

        super.setVisible(true);
    }

    private void initializeAccessoryLists() {
        // Initialize Hairpiece list
        hairpieceList = new ArrayList<>();
        hairpieceList.add(new Accessory("Tradisional Sanggul Lintang Gandik Set", "250.00", "Gandik.png"));
        hairpieceList.add(new Accessory("Sanggul Lintang Silver", "80.00", "SanggulLintang.png"));
        hairpieceList.add(new Accessory("Arabella Crown", "59.00", "ArabellaCown.png"));
        hairpieceList.add(new Accessory("Alicia Crown", "43.00", "AliciaCrown.png"));
        hairpieceList.add(new Accessory("Empress Hairpiece", "150.00", "EmpressHairpiece.png"));
        hairpieceList.add(new Accessory("Traditional Chinese Hairpin Pearl Hair Piece", "298.00", "ChineseHairPiece.png"));
        hairpieceList.add(new Accessory("Gold Tone Kundan Bridal Passa ", "234.00", "GoldPassa.png"));
        hairpieceList.add(new Accessory("Kundan And Pearls Passa", "446.00", "PearlPassa.png"));


        // Initialize Necklace list
        necklaceList = new ArrayList<>();
        necklaceList.add(new Accessory("Ethnic Brooch", "84.00", "Brooch.png"));
        necklaceList.add(new Accessory("Handmade Rose Gold Brooch", "250.00", "GoldBrooch.png"));
        necklaceList.add(new Accessory("Ying Yang Necklace", "400.00", "YingYang.png"));
        necklaceList.add(new Accessory("Thin Jade Necklace", "300.00", "ThinJade.png"));
        necklaceList.add(new Accessory("White Layered Kundan Necklace", "1500.00", "WhiteNecklace.png"));
        necklaceList.add(new Accessory("Sterling Silver Necklace", "1500.00", "SilverNecklace.png"));
        necklaceList.add(new Accessory("Pearl Drop Crystal Rose Gold Necklace", "357.90", "PearlNecklace.png"));
        necklaceList.add(new Accessory("Rose gold statement backdrop necklace", "550.00", "RoseNecklace.png"));


        // Initialize Shoes list
        shoesList = new ArrayList<>();
        shoesList.add(new Accessory("Celeste Lace Pumps - Champagne", "259.00", "CelesteHeel.png"));
        shoesList.add(new Accessory("Anthena Satin Pumps - Silver", "259.00", "SilverHeel.png"));
        shoesList.add(new Accessory("Rema Lace Pumps", "89.00", "RemaHeel.png"));
        shoesList.add(new Accessory("Heba Satin Slingback Pumps", "249.00", "HebaHeel.png"));
        shoesList.add(new Accessory("Punjabi Jutti", "399.25", "Jutti.png"));
        shoesList.add(new Accessory("Rose Gold Beaded", "304.32", "RoseBeaded.png"));
        shoesList.add(new Accessory("Daves Black Monk Strap Shoes", "1545.68", "StrapShoes.png"));
        shoesList.add(new Accessory("Newry Cream Penny Loafers", "1798.03", "PennyLoafers.png"));
        shoesList.add(new Accessory("Dartmouth Black Loafers", "1212.21", "BlackLoafers.png"));
        shoesList.add(new Accessory("Black Classic Leather Comfort", "208.15", "LeatherComfort.png"));

        // Initialize Bracelet list
        braceletList = new ArrayList<>();
        braceletList.add(new Accessory("Classic Gold Bracelet", "89.00", "ClassicGold.png"));
        braceletList.add(new Accessory("Classic Silver Bracelet", "89.00", "ClassicSilver.png"));
        braceletList.add(new Accessory("Dragon and Phoenix Bangels", "3000.00", "PheonixBangels.png"));
        braceletList.add(new Accessory("Fortune Bangle", "183.00", "FortuneBangle.png"));
        braceletList.add(new Accessory("Luxury Lucie Bangle stack - Maroon Multishade", "488.30", "LuxuryBangle.png"));
        braceletList.add(new Accessory("Roshni Luxury Bangle Set - Silver & Pink", "493.80", "RoshniBangle.png"));
        braceletList.add(new Accessory("Long Slider Bracelet", "788.60", "SliderBracelet.png"));
        braceletList.add(new Accessory("Leaves and Branches Rose Gold bracelet", "131.00", "LeavesBracelet.png"));

        // Initialize Veil list
        veilList = new ArrayList<>();
        veilList.add(new Accessory("Juliet Veil", "69.00", "JulietVeil.png"));
        veilList.add(new Accessory("Hanna Veil", "69.00", "HannaVeil.png"));
        veilList.add(new Accessory("Whimsical Metalic Floral Veil", "70.00", "FloralVeil.png"));
        veilList.add(new Accessory("Demure Lace Applique Veil", "59.00", "DemureVeil.png"));
        veilList.add(new Accessory("Yurra Veil", "69.00", "YurraVeil.png"));
        veilList.add(new Accessory("Chix Plain Short Veil", "69.00", "ShortVeil.png"));

        // Initialize Earing list
        earingList = new ArrayList<>();
        earingList.add(new Accessory("Pearl Drop Earrings", "116.70", "PearlEar.png"));
        earingList.add(new Accessory("Rosa Hoop Earrings", "273.00", "RosaEAr.png"));
        earingList.add(new Accessory("Pearl Earrings", "169.90", "PearlIndianEar.png"));
        earingList.add(new Accessory("Amreen Jhumka Earrings", "246.90", "AmreenEar.png"));
        earingList.add(new Accessory("Pearl Ball Earings ", "58.50", "BallEar.png"));
        earingList.add(new Accessory("Floral Jade Earrings", "126.20", "JadeEar.png"));
    }

    private void prepareAccessoriesPanel() {
        // Panel for buttons to select accessories
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));

        btnHairpiece = new JButton("Hairpiece");
        btnNecklace = new JButton("Necklace");
        btnShoes = new JButton("Shoes");
        btnBracelet = new JButton("Bracelet");
        btnVeil = new JButton("Veil");
        btnEaring = new JButton("Earing");

        buttonPanel.add(btnHairpiece);
        buttonPanel.add(btnNecklace);
        buttonPanel.add(btnShoes);
        buttonPanel.add(btnBracelet);
        buttonPanel.add(btnVeil);
        buttonPanel.add(btnEaring);

        // Add action listeners for buttons
        btnHairpiece.addActionListener(e -> showAccessoryDetails(hairpieceList));
        btnNecklace.addActionListener(e -> showAccessoryDetails(necklaceList));
        btnShoes.addActionListener(e -> showAccessoryDetails(shoesList));
        btnBracelet.addActionListener(e -> showAccessoryDetails(braceletList));
        btnVeil.addActionListener(e -> showAccessoryDetails(veilList));
        btnEaring.addActionListener(e -> showAccessoryDetails(earingList));

        // Add the button panel to the left of the frame
        add(buttonPanel, BorderLayout.WEST);

        // Panel to show the details of the selected accessory
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridBagLayout()); // Change layout to GridBagLayout for better control
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add the details panel to the center of the frame
        add(new JScrollPane(detailsPanel), BorderLayout.CENTER);
    }

    // Method to show the details of the selected accessory
    private void showAccessoryDetails(ArrayList<Accessory> accessoryList) {
        // Clear previous details
        detailsPanel.removeAll();

        // Create a ButtonGroup for radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between items
        gbc.fill = GridBagConstraints.BOTH;

        int row = 0, col = 0;
        for (Accessory accessory : accessoryList) {
            // Accessory panel
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            itemPanel.setPreferredSize(new Dimension(400, 250));

            // Accessory image
            JLabel accessoryImage;
            try {
                ImageIcon icon = new ImageIcon(accessory.getImagePath());
                Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                accessoryImage = new JLabel(new ImageIcon(scaledImage));
            } catch (Exception e) {
                accessoryImage = new JLabel("Image Not Found", JLabel.CENTER);
                accessoryImage.setPreferredSize(new Dimension(150, 150));
                accessoryImage.setHorizontalAlignment(JLabel.CENTER);
            }

            // Panel for individual accessory details
            JPanel accessoryPanel = new JPanel();
            accessoryPanel.setLayout(new BoxLayout(accessoryPanel, BoxLayout.Y_AXIS));
            accessoryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for each item

            // Accessory name and price
            JLabel nameLabel = new JLabel(accessory.getName(), JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel priceLabel = new JLabel("Price: RM " + accessory.getPrice(), JLabel.CENTER);
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Radio button
            JRadioButton radioButton = new JRadioButton("Select");
            radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonGroup.add(radioButton);

            // Add components to the item panel
            itemPanel.add(Box.createVerticalGlue());
            itemPanel.add(accessoryImage);
            itemPanel.add(Box.createVerticalStrut(5));
            itemPanel.add(nameLabel);
            itemPanel.add(priceLabel);
            itemPanel.add(radioButton);
            itemPanel.add(Box.createVerticalGlue());

            // Add item panel to details panel
            gbc.gridx = col;
            gbc.gridy = row;
            detailsPanel.add(itemPanel, gbc);

            col++;
            if (col == 2) { // 2 items per row
                col = 0;
                row++;
            }
        }

        // Refresh the details panel
        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    // Main method to display the frame
    public static void main(String[] args) {
        new Accessories();
    }
}
