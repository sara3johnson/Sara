package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Transactions {
    private LocalDateTime dateTime;
    private String description;
    private String vendorName;
    private double amount;

    public Transactions(LocalDateTime dateTime, String description, String vendor, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendorName = vendor;
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

    public String getVendor() {
        return vendorName;
    }

    public void setVendor(String vendor) {
        this.vendorName = vendor;
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
