package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.Reports.deposits;

public class Deposits {

    private LocalDateTime dateTime;
    private String description;
    private String vendorName;
    private double amount;

    public Deposits(LocalDateTime dateTime, String description, String vendorName, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendorName = vendorName;
        this.amount = amount;
    }


    public static void addDeposit(Scanner scanner) {

        try {
            System.out.println("Enter deposit description: ");
            String description = scanner.nextLine();
            System.out.println("Enter vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter deposit amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Deposits deposit = new Deposits(LocalDateTime.now(), description, vendor, amount);
            deposits.add(deposit);
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            fileWriter.write((deposit.getDateTime() + "|" + description + "|" + vendor + "|" + amount));
            fileWriter.close();
            System.out.println("Deposit saved!");
        } catch (IOException ex) {
            System.out.println("Error!");
        }
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



