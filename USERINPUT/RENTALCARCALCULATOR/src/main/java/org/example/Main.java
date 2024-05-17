package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What day would like to pickup?");
        String userResponse = scanner.nextLine();

        System.out.println("Enter the number of days for rental");
        int numberOfDays = scanner.nextInt();

        System.out.println("How old are you?");
        int userAge = scanner.nextInt();
        double surcharge = 0;

        if (userAge < 25) {
            surcharge = 29.99 * numberOfDays * 0.003;

        } else {
            surcharge = 0;
        }
            System.out.println("Do you want a Toll Tag Account?");
            boolean tolTag = scanner.nextBoolean();

            System.out.println("Do you want Roadside Assistance");
            boolean roadAssistance = scanner.nextBoolean();

            System.out.println("Do you want a GPS?");
            boolean gpsSystem = scanner.nextBoolean();
            double optionsCost = 0;
            if (tolTag) {
                optionsCost += numberOfDays * 3.95;
            }
            if (roadAssistance) {
                optionsCost += numberOfDays * 3.95;
            }
            if (gpsSystem);
            6
                double basicCarRental;

            double basicCarRental = 29.99 * numberOfDays;
            double totalCost = basicCarRental+surcharge;
        double totalCost = basicCarRental + surcharge + optionsCost;
            System.out.println();6=;


        }

        }





    }
}