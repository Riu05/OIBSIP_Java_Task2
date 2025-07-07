import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMMenuUI extends JPanel {
    JButton balanceBtn, depositBtn, withdrawBtn, txnBtn, exitBtn;
    JLabel welcomeLabel;

    public ATMMenuUI(String userId,
                     ActionListener onBalance,
                     ActionListener onDeposit,
                     ActionListener onWithdraw,
                     ActionListener onTxn,
                     ActionListener onExit) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(230, 255, 250)); // pastel mint

        welcomeLabel = new JLabel("Welcome, " + userId + "!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
        welcomeLabel.setForeground(new Color(105, 89, 205)); // pastel purple

        balanceBtn = createButton("View Balance", onBalance);
        depositBtn = createButton("Deposit", onDeposit);
        withdrawBtn = createButton("Withdraw", onWithdraw);
        txnBtn = createButton("Transaction History", onTxn);
        exitBtn = createButton("Exit", onExit);

        add(Box.createVerticalStrut(20));
        add(welcomeLabel);
        add(Box.createVerticalStrut(20));
        add(balanceBtn);
        add(depositBtn);
        add(withdrawBtn);
        add(txnBtn);
        add(exitBtn);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setBackground(new Color(255, 250, 205)); // pastel yellow
        btn.setForeground(Color.DARK_GRAY);
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(250, 40));
        btn.setFocusPainted(false);
        btn.addActionListener(action);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        return btn;
    }
}
