package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DealershipFileManager {

    //make a file input stream that points to the file that holds my vehicles
    //make a file input stream that points to the file that holds my vehicles
    //create dealership object
    //make a scanner to take in the file input stream
    //loop the thru the file until there is no more file
    //take each row and use the String.split() method to get your data
    //create a vehicle from the array, that String.split returns
    //take that vehicle and add it to the inventoryList of the desire Dealership
    //after the loop is finished , return the dealership

    //I like the use of final here, it makes it a constant.
    public static final String VEHICLES_FILE_PATH = "src/main/resources/Vehicles.csv";

    //Good this method should be static. You should probably make a private constructor for the
    //DealershipFileManager
    //I also fixed the syntax issues
        public static Dealership getDealership() {

            List<Vehicle> vehicleList = new ArrayList<>();


            Dealership dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");

            try {
                FileInputStream fileInputStream = new FileInputStream(VEHICLES_FILE_PATH);

                Scanner scanner = new Scanner(fileInputStream);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] vehicle = line.split("\\|");
                        if (vehicle.length == 8) {
                            int vin = Integer.parseInt(vehicle[0]);
                            int year = Integer.parseInt(vehicle[1]);
                            String make = vehicle[2];
                            String model = vehicle[3];
                            String vehicleType = vehicle[4];
                            String color = vehicle[5];
                            int odometer = Integer.parseInt(vehicle[6]);
                            double price = Double.parseDouble(vehicle[7]);

                            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                            vehicleList.add(newVehicle);

                            dealership.addVehicle(newVehicle);
                        } else {
                            System.out.println("Invalid data in the file: " + VEHICLES_FILE_PATH);
                        }
                    }

            } catch (IOException ex) {
                System.out.println("File not found: " + VEHICLES_FILE_PATH);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid data format in the file: " + VEHICLES_FILE_PATH);
            }

            return dealership;
        }





    public static void saveDealership(Dealership dealership) {
                try{
                    FileWriter fw = new FileWriter(VEHICLES_FILE_PATH);

                    //Write the header
                    String headerRow = String.format("%s|%s|%s %n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
                    fw.write(headerRow);

                    for(Vehicle vehicle : dealership.getAllVehicles()){
                        String row = String.format("%d|%d|%s|%s|%s|%s|%d|%f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                                vehicle.getColor(), vehicle.getVehicleType(), vehicle.getOdometer(), vehicle.getPrice());

                        fw.write(row);
                    }

                    fw.close();
                }
                catch (IOException ex){
                    System.out.println("Had a problem writing to the file cuz of: " + ex);
                }



            }

    }



