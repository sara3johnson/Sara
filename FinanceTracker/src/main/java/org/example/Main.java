package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();
    public static ArrayList<Payments> payments = new ArrayList<>();
    public static ArrayList<Deposits> deposits = new ArrayList<>();

    public static void main(String[] args) throws IOException {
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
                scanner.nextLine();
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


            public static void makePayments (Scanner scanner) {
                try {
                    System.out.println("Enter payment description");
                    String description = scanner.nextLine();
                    System.out.println("Enter vendor name: ");
                    String vendor = scanner.nextLine();
                    System.out.println("Enter payment amount: ");
                    double paymentAmount = Double.parseDouble(scanner.nextLine()); // Read payment amount as a String and then parse it to double
                    LocalDateTime dateTime = LocalDateTime.now();

                    Payments payment = new Payments(dateTime, description, vendor, paymentAmount);
                    payments.add(payment);

                    // Append the payment details to the transactions.csv file
                    FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
                    String savePayment = dateTime + "|" + description + "|" + vendor + "|" + paymentAmount + "\n";
                    fileWriter.write(savePayment);
                    fileWriter.close();

                    System.out.println("Payment saved successfully!");
                } catch (IOException | NumberFormatException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }







}
