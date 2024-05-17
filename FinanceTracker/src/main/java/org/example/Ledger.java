package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    private LocalDate date;
    private String description;
    private String vendorName;
    private double amount;
    private LocalTime time;
    private static ArrayList<Transactions> transactions = new ArrayList<>();
    private static ArrayList<Payments> payments = new ArrayList<>();
    private static ArrayList<Deposits> deposits = new ArrayList<>();

    public Ledger(LocalDate date, String description, String vendor, double amount, LocalTime time) {
        this.date = date;
        this.description = description;
        this.vendorName = vendor;
        this.amount = amount;
        this.time = time;
    }
    public String toString(){
        return String.format("Date: %s, Description: %s, Vendor: %s, Amount: %.2f, Time: %s",
                date, description, vendorName, amount, time);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendorName;
    }

    public void setVendor(String vendor) {
        this.vendorName = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public static void displayLedger(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome To the Display Ledger!");
            System.out.println("Options: ");
            System.out.println("A for All");
            System.out.println("D for Deposits");
            System.out.println("P for Payments");
            System.out.println("R for Reports");
            System.out.println("H to go Back");
            System.out.println("Enter an option: ");
            String userChoice = scanner.nextLine().toUpperCase();
//used switch case for users answers
            switch (userChoice) {
                case "A":
                    uploadTransactions();
                    displayTransaction();

                    break;
                case "D":
                    uploadTransactions();
                    displayDeposits();

                    break;
                case "P":
                    uploadTransactions();
                    displayPayments();
                    break;
                case "R":
                    uploadTransactions();
                    Reports.runReports();
                    break;
                case "H":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again");
                    break;
            }
        }
    }

        public static void uploadTransactions(){
            transactions.clear();
            deposits.clear();
            payments.clear();

            try(FileInputStream fis = new FileInputStream("src/main/resources/transactions.csv");
                Scanner scanner = new Scanner (fis)){
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] section = line.split("\\|");

                if (section.length==4) {
                    LocalDateTime dateTime = LocalDateTime.parse(section[0]);
                    String description = section[1];
                    String vendorName = section[2];
                    double amount = Double.parseDouble(section[3]);

                    Transactions transaction = new Transactions(dateTime, description, vendorName, amount);

                    if (amount >= 0) {
                        deposits.add(new Deposits(dateTime, description, vendorName, amount));
                    } else {
                        payments.add(new Payments(dateTime, description, vendorName, amount));
                    }
                    transactions.add(transaction);
                } else {
                    System.out.println("Error found: + line");
                }

                }
            }
            catch (FileNotFoundException ex) {
                System.out.println("Not found");
            } catch (IOException ex){
                System.out.println("File not found");
            }

            }


        public static void displayPayments(){
            System.out.println("Payments: ");
            for(Payments payment : payments){
                System.out.println(payment);
            }
        }

        public static void displayDeposits(){
            System.out.println("Deposits:");
            for(Deposits deposit : deposits){
                System.out.println(deposit);

            }
        }

        public static void displayTransaction(){
            System.out.println("Transactions:");
            for(Transactions transaction : transactions){
                System.out.println(transaction);
            }


        }


}

