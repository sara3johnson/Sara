package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.Main.payments;

public class Payments {
    /*public static void makePayment(Scanner scanner){

            try {
            System.out.println("Enter payment description: ");
            String description = scanner.nextLine();
            System.out.println("Enter vendor name: ");
            String vendorName = scanner.nextLine();
            System.out.println("Enter payment amount: ");
            double paymentAmount = Double.parseDouble(scanner.nextLine());

            Payments payment = new Payments(LocalDateTime.now(), description, vendorName, paymentAmount);
            payments.add(payment);

            System.out.println("Payment saved successfully!");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
   } **FIXED THIS PAYMENT METHOD*/
    public static void makePayment (Scanner scanner) {
        try {
            System.out.println("What would you like to pay with?");
            String description = scanner.nextLine();
            System.out.println("Enter vendor name: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter payment amount: ");
            double paymentAmount = Double.parseDouble(scanner.nextLine()); // Read payment amount as a String and then parse it to double
            LocalDateTime dateTime = LocalDateTime.now();

            Payments payment = new Payments(dateTime, description, vendor, paymentAmount);
            payments.add(payment);

            // Append the payment details to the transactions.csv file //**fixed file writer here
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            String savePayment = dateTime + "|" + description + "|" + vendor + "|" + (-paymentAmount) + "\n";
            fileWriter.write(savePayment);
            fileWriter.close();

            System.out.println("Payment saved successfully!");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private LocalDateTime dateTime;
    private String description;
    private String vendorName;
    private double amount;

    public Payments(LocalDateTime dateTime, String description, String vendorName, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendorName = vendorName;
        this.amount = amount;
    }




    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString(){
        return "Date: " + dateTime.toLocalDate() +
                " | Time: " + dateTime.toLocalTime() +
                " | Description: " + description +
                " | Vendor: " + vendorName +
                " | Amount: " + amount;
    }


}
