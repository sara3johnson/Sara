package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

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

    private DealershipFileManager(){

    }

   // public static final String VEHICLES_FILE_PATH = "src/main/resources/Vehicles.csv";
        public static Dealership getDealership() {

            Dealership dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");


            //List<Vehicle> vehicleList = new ArrayList<>();

            try {
               FileInputStream fileInputStream = new FileInputStream("src/main/resources/vehicles.csv");

                Scanner scanner = new Scanner(fileInputStream);

                scanner.nextLine();

                    String input;
                    while (scanner.hasNextLine()) {
                        input = scanner.nextLine();
                        String[] dataRow = input.split("\\|");
                        Vehicle vehicle = new Vehicle(Integer.parseInt(dataRow[0]), Integer.parseInt(dataRow[1]), dataRow[2],
                                dataRow[3], dataRow[4], dataRow[5], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));

                        dealership.addVehicle(vehicle);
                    }
            }
            catch(FileNotFoundException ex){
                System.out.println("error finding file to read");
            }

            return dealership;

        }





    public static void saveDealership(Dealership dealership) {
                try{
                    FileWriter fw = new FileWriter("src/main/resources/vehicles.csv");

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
                    System.out.println("error writing to file: " + ex);
                }



            }

    }



