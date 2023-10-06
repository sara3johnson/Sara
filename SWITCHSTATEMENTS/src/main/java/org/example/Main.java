package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What's your favorite day of the week?");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        switch(userInput){
            case "Monday":
                System.out.println("Weird bro..");
                break;
            case "Tuesday":
                System.out.println("Tuesday's suck...");
                break;
            case "Wednesday":
                    System.out.println("At least you're halfway there!");
                break;
            case "Thursday":
                System.out.println("That's almost friday!");
                break;
            case "Friday":
                System.out.println("I LOVE FRIYAYS!");
                break;
            case "Saturday":
                System.out.println("YEAA PARTY!");
                break;
            case "Sunday":
                System.out.println("Time to rest girly!");
                break;
            default:




        }


    }
}