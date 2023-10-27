package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FinancialTracker {

    public class Transaction {
        public Transaction(String description, String vendor, double amount) {
        }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;


            while(isRunning){
                System.out.println("Welcome to the Financial Tracker Application");
                System.out.println("Please select from the following options");
                System.out.println("D - Add Deposit");
                System.out.println("P - Make a Payment");
                System.out.println("L - Display ledger screen");
                System.out.println("X - Exit");
                System.out.println("Enter your choice: ");
                String userChoice = scanner.nextLine().toUpperCase();

                switch(userChoice) {
                    case "D":
                        addDeposit(scanner);
                        break;
                    case "P":
                        makePayment(scanner);
                        break;
                    case "L":
                        displayLedger(scanner);
                        break;
                    case "X":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("That is not an option");}
                saveTransaction();
                System.out.println("Thank you for using the Financial Tracker App!");
                }

    }

    private static void saveTransaction() {
    }
    }

    private static void displayLedger(Scanner displayAccount) {
        Transaction[] transactions = new Transaction[0];
        Collections.reverse(Transactions);
        for(Transaction transaction1 : transactions){
            System.out.println(transaction1);
        }
    }
    private static void displayTransactions(ArrayList<Transaction> transactions) {
    }

    private void makePayment(Transaction makePayment) {
        System.out.println("Enter debit card number");
        String debitCard = scanner.nextInt();
        System.out.println("Enter vendor: ");
        String vendor1 = scanner.nextLine();
        System.out.println("Enter payment amount: ");
        double paymentAmount = -Double.parseDouble(scanner.nextLine());
        transactions.add(new Transaction(debitCard, vendor1,paymentAmount));
        System.out.println("Payment successful!");
    }

    private void addDeposit(Scanner scanner) {
        System.out.println("Enter deposit description: ");
        String description = scanner.nextLine();
        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter deposit amount: ");
        double depositAmount = Double.parseDouble(scanner.nextLine());
        transactions.add(new Transaction(description, vendor, depositAmount));
        System.out.println("Deposit added successfully!");
    }

    private static void getDeposits(double deposits)
        for(Transaction transaction : transactions){
            if(transaction.getAmount() > 0)
                deposits.add(transaction);private static void saveTransaction() {

    public class Transaction {
    private static void displayAccount(Scanner scanner) {
        System.out.println("Please select from the following options:");
        System.out.println("A for All");
        System.out.println("D for Deposits");
        System.out.println("P for Payments");
        System.out.println("R for Reports");
        System.out.println("O to go Back");
        System.out.println("Enter your choice: ");
        String userChoice = scanner.nextLine().toUpperCase();

        switch (userChoice) {
            case "A":
                ArrayList<FinancialTracker.Transaction> transactions = new ArrayList<>();
                displayTransactions(transactions);
                break;
            case "D":
                displayTransactions(getDeposits());
                break;
            case "P":
                displayTransactions(getPayments());
            case "R":
                runReports(scanner);
                break;
            case "O":
                break;
            default:
                System.out.println("Not an option. Please try again.");
                break;

        }

                }

        private static Transaction getPayments() {
            for(Transaction transaction1 : transactions) {
                if (transaction.getAmount() < 0){
                    payments.add(transaction1);
        }
    }

}
    }


}

}

    private static void runReports(Scanner reports) {
    }
}
