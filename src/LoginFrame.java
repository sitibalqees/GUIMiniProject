import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class LoginFrame extends JFrame implements ActionListener {

    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkShowPassword;
    private JButton btnLogin, btnRegister;

    public LoginFrame() {
        super.setTitle("Please Login");
        super.setSize(300, 400);

        prepareCenterPanel();
        prepareSouthPanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void prepareSouthPanel() {
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new FlowLayout());

        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");


        // Register btnLogin to listener
        btnLogin.addActionListener(this);

        // Register btnRegister to listener
        btnRegister.addActionListener(e -> {
            new RegisterFrame(); // Open the RegisterFrame
            super.setVisible(false); // Optionally hide the login window
        });

        pnlSouth.add(btnLogin);
        pnlSouth.add(btnRegister);

        super.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
    }

    private void prepareCenterPanel() {
        JPanel pnlLogo = new JPanel();
        pnlLogo.setLayout(new FlowLayout());
        try {
            BufferedImage myPicture = ImageIO.read(new File("logo.jpg"));
            ImageIcon imgIcon = new ImageIcon(myPicture);
            Image scaledImage = imgIcon.getImage()
                    .getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(scaledImage));
            pnlLogo.add(logo);
        } catch (IOException ioe) {
            System.err.println("Logo file not found");
        }

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(4, 2));

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 30));

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 30));

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.BOLD, 30));

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.BOLD, 30));

        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setFont(new Font("Arial", Font.BOLD, 30));


        chkShowPassword.addActionListener(e -> {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('*');
            }
        });

        pnlForm.add(lblUsername);
        pnlForm.add(txtUsername);
        pnlForm.add(lblPassword);
        pnlForm.add(txtPassword);
        pnlForm.add(new JLabel());
        pnlForm.add(chkShowPassword);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2, 1));
        pnlCenter.add(pnlLogo);
        pnlCenter.add(pnlForm);

        super.getContentPane().add(pnlCenter, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username and password cannot be empty!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate credentials
            if (validateCredentials(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                super.setVisible(false); // hide the login
                new WeddingManagementSystem(); // Open the main application window
                // Proceed to the next screen (e.g., BookingFrame or Dashboard)
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true; // Valid credentials
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading user data!", "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return false; // Invalid credentials
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}