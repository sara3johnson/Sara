package org.example;
import java.util.Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = Scanner(System.in);
        System.out.print("How is the weather today?: Sunny, Cloudy, Rainy");
        String weatherAnswer = new scanner.nextln();


        if(weatherAnswer.equalsIgnoreCase("Sunny")) {
            System.out.print("It's a great day for outdoor activities!");
        }else if(weatherAnswer.equalsIgnoreCase("Cloudy")){
            System.out.print("The weather is a bit uncertain.");
        else if(weatherAnswer.equalsIgnoreCase("Rainy")) {
            System.out.print("");

            }

        }
    }
}