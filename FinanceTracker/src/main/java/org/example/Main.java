package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Reports.deposits;


public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();
    public static ArrayList<Payments> payments = new ArrayList<>();
    public static ArrayList<Deposits> addDeposit = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            boolean isRunning = true;


//created a IO exception to catch any problems
            while (isRunning) {
                System.out.println("Welcome to Sara's Financial Tracker Application!");
                System.out.println("Please select from the following options");
                System.out.println("D - Add Deposit");
                System.out.println("P - Make a Payment");
                System.out.println("L - Display ledger screen");
                System.out.println("X - Exit");
                System.out.println("What would you like to do today?: ");

                String userChoice = scanner.nextLine().toUpperCase();
               //**REMOVED REDUNDANT SCANNER scanner.nextLine();
//switch case made for user input
                switch (userChoice) {
                    case "D":
                        Deposits.addDeposit(scanner);
                        break;
                    case "P":
                        Payments.makePayment(scanner);
                        break;
                    case "L":
                        Ledger.displayLedger(scanner);
                        break;
                    case "X":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("That is not an option");
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("Invalid option. Try again");
        }
    }


    public static void addDeposit(Scanner scanner) {
        try{
            System.out.println("Enter description of deposit: ");
            String description = scanner.nextLine();
            System.out.println("Enter Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Deposits deposit = new Deposits(LocalDateTime.now(), description, vendor, amount);
            deposits.add(deposit);
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            fileWriter.write(deposit.getDateTime() + "|" + description + "|" + vendor + "|" + amount + "\n");
            fileWriter.close();
            System.out.println("Deposit successfully saved.");
        } catch(IOException exception) {
            System.out.println("Error occurred.");
        }
    }
    public static void makePayment(Scanner scanner){
        try{
            System.out.println("Enter description of payment: ");
            String description = scanner.nextLine();
            System.out.println("Enter Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Payments payment = new Payments(LocalDateTime.now(), description, vendor, amount);
            payments.add(payment);
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            fileWriter.write(payment.getDateTime() + "|" + description + "|" + vendor + "|" + (-amount) + "\n");
            fileWriter.close();
            System.out.println("Payment successfully saved.");
        } catch (IOException exception) {
            System.out.println("Error occurred while saving the payment information.");

        }
    }

}
