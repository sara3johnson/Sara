package org.example;

public class Sales extends Contract {

    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean isFinancing;


    public Sales(double salesTax, double recordingFee, double processingFee, boolean isFinancing) {
        super();
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinancing = isFinancing;
    }


    public double getSalesTax() {

        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        recordingFee = 100;
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return isFinancing;
    }

    public void setFinancing(boolean financing) {

        this.isFinancing = financing;
    }

    @Override
    public double getTotalPrice() {
        return 0;

    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
