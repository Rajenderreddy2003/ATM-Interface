import java.util.ArrayList;
import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + receiver.getAccountNumber());
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// ATM interface class
public class ATM {
    private BankAccount currentAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.currentAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice = 0;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Transaction History");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    currentAccount.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        } while (choice != 5);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit successful.");

        // Display updated balance
        System.out.println("Updated Balance: " + currentAccount.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }

        // Display updated balance
        System.out.println("Updated Balance: " + currentAccount.getBalance());
    }

    private void transfer() {
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        // In a real application, you'd retrieve the recipient's account object from a database or collection
        // For simplicity, assuming a new BankAccount object here
        BankAccount recipientAccount = new BankAccount(recipientAccountNumber);
        currentAccount.transfer(recipientAccount, amount);
        System.out.println("Transfer successful.");

        // Display updated balance
        System.out.println("Your Balance: " + currentAccount.getBalance());
    }

    public static void main(String[] args) {
        // Create a new bank account
        BankAccount account = new BankAccount("1234567890");

        // Initialize ATM with the bank account
        ATM atm = new ATM(account);

        // Run the ATM interface
        atm.run();
    }
}
