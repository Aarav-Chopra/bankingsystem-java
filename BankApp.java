// File name: BankApp.java

import java.util.Scanner;

// Class representing a Bank Account
class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Successfully withdrew ₹" + amount);
        } else if (amount > balance) {
            System.out.println("⚠️ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("💰 Current balance: ₹" + balance);
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }
}

// Main class
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ₹");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);

        int choice;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for banking with us!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
