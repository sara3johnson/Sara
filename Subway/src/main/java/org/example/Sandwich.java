package org.example;

public class Sandwich {

    private int breadLength;

    public Sandwich(int breadLength) {
        this.breadLength = breadLength;
    }

    public double calculatePrice() {


            double basePrice = 0;

            if (breadLength == 4) {
                basePrice = 5.50;
            } else if (breadLength == 8) {
                basePrice = 7.00;
            } else if (breadLength == 12) {
                basePrice = 8.50;
            } else {
                System.out.println("sorry! I don't have that size.");
                basePrice = 0;


            }



    }
}
