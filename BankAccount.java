import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposited", amount));
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawn", amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }
}

