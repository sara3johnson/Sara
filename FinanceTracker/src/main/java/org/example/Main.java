package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.HomeScreen.saveTransaction;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        List<Account> transactionList = new ArrayList<>();


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
                    HomeScreen.addDeposit((ArrayList<Account>) transactionList);
                    break;
                case "P":
                    HomeScreen.makePayment((ArrayList<Account>) transactionList);
                    break;
                case "L":
                    HomeScreen.displayLedger((ArrayList<Account>) transactionList);
                    break;
                case "X":
                    isRunning = false;
                    break;
                default:
                    System.out.println("That is not an option");}
            try {
                saveTransaction();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thank you for using the Financial Tracker App!");
        }



    }






}
