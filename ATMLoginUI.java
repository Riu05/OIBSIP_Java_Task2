import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMLoginUI extends JPanel {
    JTextField userField;
    JPasswordField pinField;
    JButton loginBtn;

    public ATMLoginUI(ActionListener loginAction) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 240, 245)); // pastel pink

        JLabel title = new JLabel("ATM Login");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(new Color(160, 82, 170)); // soft purple

        userField = new JTextField();
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userField.setMaximumSize(new Dimension(300, 40));
        userField.setBorder(BorderFactory.createTitledBorder("User ID"));

        pinField = new JPasswordField();
        pinField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pinField.setMaximumSize(new Dimension(300, 40));
        pinField.setBorder(BorderFactory.createTitledBorder("PIN"));

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.setBackground(new Color(176, 224, 230)); // pastel blue
        loginBtn.setForeground(Color.DARK_GRAY);
        loginBtn.setFocusPainted(false);
        loginBtn.setAlignmentX(CENTER_ALIGNMENT);
        loginBtn.addActionListener(loginAction);

        add(Box.createVerticalStrut(40));
        add(title);
        add(Box.createVerticalStrut(30));
        add(userField);
        add(Box.createVerticalStrut(15));
        add(pinField);
        add(Box.createVerticalStrut(30));
        add(loginBtn);
    }

    public String getUserId() {
        return userField.getText();
    }

    public String getPin() {
        return new String(pinField.getPassword());
    }
}
