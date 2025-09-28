import java.util.ArrayList;
import java.util.Scanner;
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;
    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with initial deposit: " + initialDeposit);
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid or insufficient funds!");
        }
    }
    public void showTransactionHistory() {
        System.out.println("Transaction history for " + accountHolder + " (" + accountNumber + "):");
        for (String t : transactions) {
            System.out.println(" - " + t);
        }
    }
}
public class BankApp{
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner sac = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("SIMPLE BANKING APPLICATION");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sac.nextInt();
            sac.nextLine();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> showHistory();
                case 6 -> {
                    System.out.println("Thank you for using the Banking App!");
                    return;
                }
                default -> System.out.println("Invalid choice.Please Try again.");
            }
        }
    }
    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accNo = sac.nextLine();
        System.out.print("Enter account holder name: ");
        String name = sac.nextLine();
        System.out.print("Enter initial deposit: ");
        double deposit = sac.nextDouble();
        BankAccount acc = new BankAccount(accNo, name, deposit);
        accounts.add(acc);
        System.out.println("Account created successfully!");
    }
    private static BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }
    private static void deposit() {
        System.out.print("Enter account number: ");
        String accNo = sac.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sac.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }
    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accNo = sac.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sac.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }
    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accNo = sac.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.println("Balance for " + acc.getAccountHolder() + ": " + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
    private static void showHistory() {
        System.out.print("Enter account number: ");
        String accNo = sac.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.showTransactionHistory();
        } else {
            System.out.println("Account not found!");
        }
    }
}
