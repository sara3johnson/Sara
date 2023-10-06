package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int age = 26;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bet you can't guess my age. Whole numbers only!");

        int userInput = scanner.nextInt();

        boolean playerWasCorrect = false;


        //Pseudo Code
        //they got it right
        // == != > < >= <=
        if(userInput == age){
            System.out.println("You got it right!");
            playerWasCorrect = true;
        }
        else if(userInput > age){
            System.out.println("Nope! I'm NOT that old!");

         else if {
             System.out.print("You guessed too low!");
            }
        }
        //they went over

        //they went under

        if(userInput == age){
            System.out.print("Heyy you got it right!");
        }
        else {
            System.out.println("Boo hoo, you got it wrong!");

        }

        //working with booleans
        if(playerWasCorrect == true){
            System.out.println("WINNER WINNER!!");
        }
        if(playerWasCorrect == false){
            System.out.println("SORRY You're wrong..");

            if(!playerWasCorrect){
                System.out.println("YAY!");
                //shorthand writing, means same as line 44

            }
        }
    }
}