package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private JPanel leftPanel, rightPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        initComponents();
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        pack();
    }

    private void initComponents() {
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(800, 500));
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Right panel (branding)
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0, 102, 102));
        rightPanel.setBounds(10, 0, 400, 500);
        mainPanel.add(rightPanel);
        rightPanel.setLayout(null);

        JLabel logoLabel = new JLabel();
        try {
            logoLabel.setIcon(new ImageIcon(Login.class.getResource("/image/loopy.png"))); // Adjust path for Eclipse
        } catch (Exception e) {
            logoLabel.setText("Logo Missing");
        }
        logoLabel.setBounds(75, 65, 207, 187);
        rightPanel.add(logoLabel);

        JLabel shopLabel = new JLabel("Loopy Shop");
        shopLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        shopLabel.setForeground(Color.WHITE);
        shopLabel.setBounds(103, 262, 200, 30);
        rightPanel.add(shopLabel);

        JLabel copyrightLabel = new JLabel("copyright ©Loopy All rights reserved");
        copyrightLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        copyrightLabel.setForeground(new Color(204, 204, 204));
        copyrightLabel.setBounds(40, 400, 300, 20);
        rightPanel.add(copyrightLabel);

        // Left panel (login form)
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(400, 0, 400, 500);
        mainPanel.add(leftPanel);
        leftPanel.setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        loginLabel.setForeground(new Color(0, 102, 102));
        loginLabel.setBounds(138, 51, 150, 50);
        leftPanel.add(loginLabel);

        JLabel usernameLabel = new JLabel("Tên đăng nhập");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameLabel.setBounds(30, 141, 100, 20);
        leftPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setForeground(new Color(102, 102, 102));
        usernameField.setBounds(30, 173, 343, 40);
        leftPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Mật khẩu");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setBounds(30, 231, 100, 20);
        leftPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(30, 263, 343, 40);
        leftPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 102, 102));
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(30, 329, 93, 36);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        leftPanel.add(loginButton);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Placeholder validation (replace with actual database check)
        if (username.equals("admin") && password.equals("password123")) {
            try {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
                mainGUI.setLocationRelativeTo(null);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening MainGUI: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}