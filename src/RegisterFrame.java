import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame implements ActionListener {

    private JLabel lblUsername, lblPassword, lblConfirmPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JCheckBox chkShowPassword;
    private JButton btnRegister;

    public RegisterFrame() {
        super.setTitle("Register");
        super.setSize(1600, 800);

        // Set beige background for the entire frame
        super.getContentPane().setBackground(new Color(255,229,204)); // Beige color

        prepareCenterPanel();
        prepareSouthPanel();

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void prepareSouthPanel() {
        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 20));

        // Register btnRegister to listener
        btnRegister.addActionListener(this);

        // Add padding and background color for the button panel
        JPanel pnlSouth = new JPanel();
        pnlSouth.setBackground(new Color(255,229,204)); // Match the frame's background color
        pnlSouth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlSouth.add(btnRegister);

        super.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
    }

    private void prepareCenterPanel() {
        JPanel pnlLogo = new JPanel();
        pnlLogo.setLayout(new FlowLayout());
        pnlLogo.setBackground(new Color(255,229,204)); // Match the frame's background color
        try {
            BufferedImage myPicture = ImageIO.read(new File("logo.jpg"));
            ImageIcon imgIcon = new ImageIcon(myPicture);
            Image scaledImage = imgIcon.getImage()
                    .getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(scaledImage));
            pnlLogo.add(logo);
        } catch (IOException ioe) {
            System.err.println("Logo file not found");
        }

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(4, 2));
        pnlForm.setBackground(new Color(255,229,204)); // Match the frame's background color

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 30));
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 30));
        lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 30));
        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.BOLD, 30));
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.BOLD, 30));
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Arial", Font.BOLD, 30));
        chkShowPassword = new JCheckBox("Show Password");

        // Match checkbox background to frame's color
        chkShowPassword.setBackground(new Color(255,229,204));
        chkShowPassword.addActionListener(e -> {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0);
                txtConfirmPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('*');
                txtConfirmPassword.setEchoChar('*');
            }
        });

        pnlForm.add(lblUsername);
        pnlForm.add(txtUsername);
        pnlForm.add(lblPassword);
        pnlForm.add(txtPassword);
        pnlForm.add(lblConfirmPassword);
        pnlForm.add(txtConfirmPassword);
        pnlForm.add(new JLabel());
        pnlForm.add(chkShowPassword);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2, 1));
        pnlCenter.setBackground(new Color(255,229,204)); // Match the frame's background color
        pnlCenter.add(pnlLogo);
        pnlCenter.add(pnlForm);

        super.getContentPane().add(pnlCenter, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String confirmPassword = String.valueOf(txtConfirmPassword.getPassword());

            if (username.isEmpty() ||  password.isEmpty() ||  confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save data to a file
            saveUserData(username, password);

            JOptionPane.showMessageDialog(null, "Registration Successful!");
            super.setVisible(false); // Hide the registration window

            // Open the login window
            new LoginFrame();
        }
    }

    private void saveUserData(String username, String password) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(username + "," + password + System.lineSeparator());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error saving user data!", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RegisterFrame();
    }
}