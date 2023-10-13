package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your numerical score:");
        int numericalScore = scanner.nextInt();

        scanner.nextLine();

        if (numericalScore >= 90 && numericalScore <= 100) {
            System.out.println("You scored an A, great job!");
        } else if (numericalScore >= 80 && numericalScore <= 89) {
            System.out.println("You scored a B, nice job.");
        } else if (numericalScore >= 70 && numericalScore <= 79) {
            System.out.println("You scored a C.");
        } else if (numericalScore >= 60 && numericalScore <= 69) {
            System.out.println("You scored a D.");
        } else if (numericalScore < 70) {
            System.out.println("You scored an F, better luck next time!");


            scanner.close();







        }
    }
}