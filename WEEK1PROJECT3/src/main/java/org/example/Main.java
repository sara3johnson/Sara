package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // accept monthly payout amount (PMT)
        System.out.print("Enter preferred monthly payment amount:");
        double monthlyPayout = scanner.nextDouble();

        // accept interest rate (r)
        System.out.print("What is your expected interest rate?:");
        double interestRate = scanner.nextDouble() / 100;

        // accept number of years to pay out (t)
        System.out.print("How long would you like your loan to be?");
        double loanLength = scanner.nextDouble();

        // calculate monthly interest rate (r)/12/100
        double monthlyInterest = interestRate / 12 / 100;
        // calculate monthly payments (n) = (t)*12
        double monthlyPayments = loanLength * 12;
        // calculate the present value of the annuity
        // PV = PMT × [(1 - (1 + r)^(-n)) / r]
        double PV = monthlyPayout * (1 - Math.pow(1 + interestRate, -monthlyPayments)) / interestRate;

        // print results of present value of the annuity
        System.out.printf("The present value of the annuity is: $%.2f%n", PV);
        System.out.println();








    }
}