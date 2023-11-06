package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.Main.payments;

public class Payments {
    public static void makePayment(Scanner scanner){

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
