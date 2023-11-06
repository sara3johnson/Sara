package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports {

    private static ArrayList<Transactions> transactions = new ArrayList<>();
    public static ArrayList<Payments> payments = new ArrayList<>();
    public static ArrayList<Deposits> deposits = new ArrayList<>();


// created a method to run transaction reports
    public static void runReports() {
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

        int userChoice = scanner.nextInt();
        scanner.nextLine();

    switch (userChoice){
        case 1:
            monthToDate(transactions);
            uploadTransactions();
            //month to date
            break;
        case 2:
            previousMonth(transactions);
            uploadTransactions();
            //previous month report
            break;
        case 3:
            yearToDate(transactions);
            uploadTransactions();
            //year to date
            break;
        case 4:
            previousYear(transactions);
            uploadTransactions();
            //previous year
            break;
        case 5:
            uploadTransactions();
            System.out.println("Enter vendor name: ");
            String vendorName = scanner.nextLine();
            searchByVendor(transactions);
            break;
        case 6:
            isChoosing = false;
            break;
        default:
            System.out.println("Error. Please Try again.");
            break;
        }


    }

    // create a method to search by vendor
    private static void searchByVendor(ArrayList<Transactions> transactions) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vendor name: ");
        String vendorName = scanner.nextLine();
        boolean found = false;


    for (Transactions transaction : transactions){
        if(vendorName.equalsIgnoreCase(transaction.getVendor())){
            System.out.println(transaction);
            found = true;
        }
    }
    if(!found){
        System.out.println(("No transactions found from this vendor: " + vendorName));
    }

    }

    //create method for previous year search
    private static void previousYear(ArrayList<Transactions> transactionList) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        //formula to calculate previous year
        int previousYear = currentYear - 1;

        double deposits = 0;
        double payments = 0;

        for(Transactions transaction : transactionList){
            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
            int transactionYear = transactionDate.getYear();

        if(transactionYear == previousYear){
            if(transaction.getAmount() > 0){
                deposits += Math.abs(transaction.getAmount());
            }
        }
            System.out.printf("Previous year: ");
            System.out.println("Deposits: $" + deposits);
            System.out.println("Payments: $" + payments);

        }

    }

//year to date search method
    private static void yearToDate(ArrayList<Transactions> transactions){
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        double totalDeposits = 0;
        double totalPayments = 0;

        for(Transactions transaction : transactions){
            LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
            int transactionYear = transactionDate.getYear();

            if(transactionYear == currentYear){
                if(transaction.getAmount() > 0) {
                } else {
                    totalPayments += Math.abs(transaction.getAmount());
                }
            }
        }

        System.out.println("Year to Date: ");
        System.out.println("Total Deposits: $" + totalDeposits);
        System.out.println("Total Payments: $" + totalPayments);
    }

    //create previous month search method
    private static void previousMonth(ArrayList<Transactions> transactionList) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear  = currentDate.getYear();

        //previous year formula
        int previousMonth = (currentMonth - 1 == 0) ? 12 : currentMonth - 1;
        int previousYear = (currentMonth - 1 == 0) ? currentYear - 1 : currentYear;

        for(Transactions transaction : transactionList){
            LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
            int transactionMonth = transactionDate.getMonthValue();
            int transactionYear = transactionDate.getYear();

            double payments = 0;
            double deposits = 0;

            if (transactionMonth == previousMonth && transactionYear == previousMonth){
                if(transaction.getAmount() > 0) {
                    deposits += transaction.getAmount();
                }else {
                    payments += Math.abs(transaction.getAmount());
                }
            }
        }
        System.out.println("Previous Month: ");
        System.out.println("Deposits: $" + deposits);
        System.out.println("Payments: $" + payments);

    }
//create a month to date search method
    private static void monthToDate(ArrayList<Transactions> transactionList) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getYear();
        int currentYear = currentDate.getYear();

        double deposits = 0;
        double payments = 0;

        for(Transactions transaction : transactionList){
            LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
            int transactionMonth = transactionDate.getMonthValue();
            int transactionYear = transactionDate.getYear();

            if(transactionMonth == currentMonth && transactionYear == currentYear){
                if(transaction.getAmount() > 0) {
                    deposits += transaction.getAmount();
                } else{
                    payments += Math.abs(transaction.getAmount());
                }
            }

        }
        System.out.println("Month to Date: ");
        System.out.println("Deposits:  $" + deposits);
        System.out.println("Payments" + payments);


    }


    public static void uploadTransactions(){
        transactions.clear();

    }




}