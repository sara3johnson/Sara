package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {

    private static ArrayList<Account> transactionList = new ArrayList<>();
    private static final String TRANSACTIONS_FILE_PATH = "src/main/resources/transactions.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    static void readTransactionsFromCSV(){
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null){

    String[]data = line.split("\\|");

    //parse data and create Account object
                LocalDate date = LocalDate.parse(data[0], DATE_FORMATTER);
                LocalTime time = LocalTime.parse(data[1], TIME_FORMATTER);
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);

                Account transaction = new Account(date, description, vendor, amount, time);
                transactionList.add(transaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //create add deposit method
    static void addDeposit(ArrayList<Account> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter deposit description: ");
        String description = scanner.nextLine();
        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter deposit amount: ");
        // Add deposit method  here
    }
//create make payment method
    static void makePayment(ArrayList<Account> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a description");
        String description = scanner.nextLine();
        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();
        System.out.println("Payment successful!");
        // Make payment method  here
    }
//display ledger method
    public static void displayLedger(ArrayList<Account> transactionList) {
        System.out.println("Welcome To the Display Ledger!");
        System.out.println("Options: ");
        System.out.println("A for All");
        System.out.println("D for Deposits");
        System.out.println("P for Payments");
        System.out.println("R for Reports");
        System.out.println("O to go Back");
        System.out.println("Enter an option: ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine().toUpperCase();
//used switch case for users answers
        switch (userChoice) {
            case "A":
                System.out.println("Display all: ");
                displayAll(transactionList);
                break;
            case "D":
                displayDeposits(transactionList);
                break;
            case "P":
                displayPayments(transactionList);
                break;
            case "R":
                runReports(transactionList);
                break;

            default:
                System.out.println("Invalid choice. Please try again");
                break;
        }
    }
// created a method to run transaction reports
    private static void runReports(ArrayList<Account> transactionList) {
        Scanner scanner = new Scanner(System.in);
        boolean isChoosing = true;

        System.out.println("Reports Page: ");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) To go Back");
        System.out.println("Enter you choice: ");
        String choice = scanner.nextLine();

    switch (choice){
        case "1":
            monthToDate(transactionList);
            //month to date
            break;
        case "2":
            previousMonth(transactionList);
            //previous month report
            break;
        case "3":
            yearToDate(transactionList);
            //year to date
            break;
        case "4":
            previousYear(transactionList);
            //previous year
            break;
        case "5":
           searchByVendor(transactionList);

            System.out.println("Enter vendor name: ");
            String vendorName = scanner.nextLine();
            break;
        case "0":
            isChoosing = true;
            break;
        default:
            System.out.println("Invalid decision. Please Try again.");
            break;
        }


    }
// create a method to search by vendor
    private static void searchByVendor(ArrayList<Account> transactionList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vendor name: ");
        String vendorName = scanner.nextLine();

        List<Account> filteredTransaction = new ArrayList<>();

        for(Account transaction : transactionList){
            if(transaction.getVendor().equalsIgnoreCase(vendorName)){
                filteredTransaction.add(transaction);
            }
            displayTransactions(filteredTransaction);
        }

    }

    //create method for previous year search
    private static void previousYear(ArrayList<Account> transactionList) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);
        LocalDate endOfPreviousYEar = currentDate.withDayOfYear(1).minusDays(1);

        List<Account> filteredTransaction = new ArrayList<>();

        for(Account transaction : transactionList){
            LocalDate transactionDate = transaction.getDate();
        if(transactionDate.isAfter(startOfPreviousYear) && transactionDate.isBefore(endOfPreviousYEar)){
            filteredTransaction.add(transaction);
        }
        displayTransactions(filteredTransaction);

        }

    }

    private static void displayTransactions(List<Account> filteredTransaction) {
        for(Account transaction : filteredTransaction){
            System.out.println("Date: " + transaction.getDate() + "Description: " + transaction.getDescription() + "Vendor: " + transaction.getVendor() + "Amount: " + transaction.getAmount());
        }

    }
//year to date search method
    private static void yearToDate(ArrayList<Account> transactionList) {
        LocalDate currentDate = LocalDate.now();
        List<Account> filteredTransactions = new ArrayList<>();

        for(Account transaction : transactionList){
            if(transaction.getDate().getYear() == currentDate.getYear()){
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);

    }
    //create previous month search method
    private static void previousMonth(ArrayList<Account> transactionList) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfPreviousMonth = currentDate.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfPreviousMonth = currentDate.withDayOfMonth(1).minusDays(1);

        List<Account> filteredTransaction = new ArrayList<>();

        for(Account transaction : transactionList){
            LocalDate transactionDate = transaction.getDate();
            if(transactionDate.isAfter(startOfPreviousMonth) && transactionDate.isBefore(endOfPreviousMonth)){
                filteredTransaction.add(transaction);
            }
        }
        displayTransactions(filteredTransaction);
    }
//create a month to date search method
    private static void monthToDate(ArrayList<Account> transactionList) {
        LocalDate currentDate = LocalDate.now();
        List<Account> filteredTransactions = new ArrayList<>();

        for(Account transaction : transactionList){
            if(transaction.getDate().getMonth() == currentDate.getMonth()){
                filteredTransactions.add(transaction);
            }
        }
        displayTransactions(filteredTransactions);
    }

//create display all method
    static void displayAll(ArrayList<Account> transactionList) {
        transactionList.sort(Comparator.comparing(Account::getDate).reversed());

        for (Account transaction : transactionList) {
            System.out.println(transaction);
        }
    }
///create display deposits method
    private static void displayDeposits(ArrayList<Account> transactionList) {
        transactionList.sort(Comparator.comparing(Account::getDate).reversed());

        for (Account transaction : transactionList) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }
//create display payments method
    private static void displayPayments(ArrayList<Account> transactionList) {
        transactionList.sort(Comparator.comparing(Account::getDate).reversed());

        for (Account transaction : transactionList) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }
// this method saves transactions
    static void saveTransaction() throws IOException {
        try{
            File file = new File("src/main/resources/transactions.csv");

            boolean fileExists = file.exists();

            FileWriter transactionWriter = new FileWriter("src/main/resources/transactions.csv", true);
            for(Account transaction : transactionList){
                String data = transaction.getDate() + "|" + transaction.getDescription() + "|" +
                        transaction.getVendor() + "|" + transaction.getAmount() + "\n";
                transactionWriter.write(data);
            }
            transactionWriter.close();
            System.out.println("Transactions saved successfully!");
        }
        catch (IOException ex){
            System.out.println("Error reading transactions from CSV." + ex.getMessage());
        }
    }



}