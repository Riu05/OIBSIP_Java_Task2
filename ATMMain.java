import javax.swing.*;
import java.awt.*;

public class ATMMain {
    private static BankAccount account = new BankAccount();

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM Interface");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel cards = new JPanel(new CardLayout());

        // Fix: use wrapper array for lambda scope
        ATMLoginUI[] loginUI = new ATMLoginUI[1];

        loginUI[0] = new ATMLoginUI(e -> {
            String user = loginUI[0].getUserId();
            String pin = loginUI[0].getPin();

            if (user.equals("riya") && pin.equals("2002")) {
                ATMMenuUI menuUI = createMenuUI(user, cards, frame);
                cards.add(menuUI, "menu");
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "menu");
            } else {
                JOptionPane.showMessageDialog(frame, " Invalid credentials!");
            }
        });

        cards.add(loginUI[0], "login");

        frame.add(cards);
        frame.setVisible(true);
    }

    private static ATMMenuUI createMenuUI(String userId, JPanel cards, JFrame frame) {
        return new ATMMenuUI(
                userId,
                e -> JOptionPane.showMessageDialog(frame, "Balance: ₹" + account.getBalance()),
                e -> {
                    String input = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                    try {
                        double amt = Double.parseDouble(input);
                        account.deposit(amt);
                        JOptionPane.showMessageDialog(frame, "Deposit Successful!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid Amount");
                    }
                },
                e -> {
                    String input = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                    try {
                        double amt = Double.parseDouble(input);
                        if (account.withdraw(amt)) {
                            JOptionPane.showMessageDialog(frame, "Withdrawal Successful!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Insufficient balance");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid Amount");
                    }
                },
                e -> {
                    if (account.getTransactionHistory().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No transactions yet.");
                    } else {
                        StringBuilder history = new StringBuilder();
                        for (Transaction txn : account.getTransactionHistory()) {
                            history.append("• ").append(txn).append("\n");
                        }
                        JOptionPane.showMessageDialog(frame, history.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                    }
                },
                e -> {
                    int confirm = JOptionPane.showConfirmDialog(frame, "Do you really want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
        );
    }
}
