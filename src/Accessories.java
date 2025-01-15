import javax.swing.*;
import java.awt.*;

public class Accessories extends JFrame {

    private JButton btnCrown, btnNecklace, btnShoes;


    // Constructor
    public Accessories() {
        super.setTitle("ACCESSORIES");
        super.setSize(500,650);

        //title
        JLabel AccLable = new JLabel("ACCESSORIES", JLabel.CENTER);
        AccLable.setFont(new Font("Felix Titling", Font.BOLD, 60));
        AccLable.setForeground(Color.BLACK);

        // Add padding around the title
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0)); // Add padding: top, left, bottom, right
        titlePanel.add(AccLable, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        preparePanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void preparePanel(){
        btnCrown = new JButton("Crown");
        btnNecklace = new JButton("Necklace");
        btnShoes = new JButton("Shoes");

        //set size
        btnCrown.setPreferredSize(new Dimension(100,80));
        btnNecklace.setPreferredSize(new Dimension(100,80));
        btnShoes.setPreferredSize(new Dimension(100,80));

        //create panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,20,20));
        panel.add(btnCrown);
        panel.add(btnNecklace);
        panel.add(btnShoes);

        JPanel Centerpnl = new JPanel(new GridBagLayout());
        Centerpnl.add(panel);

        super.getContentPane().add(Centerpnl, BorderLayout.WEST);
    }





    // Method to display dress details
    public static void main(String[]args){
        new Accessories();   //create obj of this class
    }





}
