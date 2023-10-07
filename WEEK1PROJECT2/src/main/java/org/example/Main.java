package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

  //  take deposit (P)
  System.out.print("Enter initial deposit:");
  double initialDeposit = scanner.nextDouble();

  // take annual interest rate (r)
  System.out.print("Enter annual interest rate:");
  double annualInterest = scanner.nextDouble();

  // take number of years (t)
   System.out.print("Enter number of years:");
   double loanLength = scanner.nextDouble();
   double interestRate = annualInterest / 100;

  // calculate daily interest rate
        double compoundsPerYear = 365;
        double dailyRate = interestRate / compoundsPerYear;
        int compounds = 365;


  // calculate FV = P(1 + r/n)^(n*t)
        double futureValue = initialDeposit * Math.pow(1 + (dailyRate / compoundsPerYear), compoundsPerYear * loanLength);

  // calculate Total Interest = FV - P
        double totalInterest = futureValue - initialDeposit;


        // print results

    System.out.printf("The future value of your compound is %.2fn", futureValue);
    System.out.printf("The total interest you have earned is %.2fn", totalInterest);









    }
}