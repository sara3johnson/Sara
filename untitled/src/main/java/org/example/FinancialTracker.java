package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class FinancialTracker {
    private static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        try{
            while(isRunning){
                System.out.println("Welcome to the Financial Tracker Application");
                System.out.println("Please select from the following options");
                System.out.println("D - Add Deposit");
                System.out.println("P - Make a Deposit");
                System.out.println("L - Display ledger screen");
                System.out.println("X - Exit");
                System.out.println("Enter your choice: ");
                String userChoice = scanner.nextLine().toUpperCase();

                switch(userChoice) {
                    case "D":
                        addDeposit(scanner);
                        break;
                }


            }

        }
        catch

    }
}