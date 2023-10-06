package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//    take user principal loan amount (P)
        System.out.print("Enter Initial Payment Amount:");
        double userPrincipalAmount = scanner.nextDouble();

//    take user interest rate (r)
        System.out.print("Enter Annual Interest Rate:");
        double annualInterestRate = scanner.nextDouble();

//    loan length (n)
        System.out.print("Enter Loan Length:");
        double loanLength = scanner.nextDouble();

//    monthly interest rate
        double monthlyInterestRate = (annualInterestRate / 12) / 100;

//    # of monthly payments
        double numberOfPayments = loanLength * 12;

//    total interest

        double monthlyPayments =  userPrincipalAmount*(monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        double totalInterest = (monthlyPayments * numberOfPayments) * userPrincipalAmount;

//    show results

        System.out.printf("Monthly Payment is: %.2f%n", monthlyPayments);

        System.out.printf("Total interest paid: %.2f%n", totalInterest);









    }
}