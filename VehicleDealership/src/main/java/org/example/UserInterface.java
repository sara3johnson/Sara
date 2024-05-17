package org.example;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public Dealership dealership;

    public void display() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.printf("Welcome to Sara's Dealership Menu!! " );
            System.out.println("Please select from the following options:  ");
            System.out.println("1. View all vehicles");
            System.out.println("2. Search for vehicles by price");
            System.out.println("3. Search for vehicles by make/model");
            System.out.println("4. Search for vehicles by year");
            System.out.println("5. Search for vehicles by color");
            System.out.println("6. Search for vehicles by mileage");
            System.out.println("7. Search for vehicles by vehicleType");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Exit Program!");

            int userInput = scanner.nextInt();

            switch (userInput) {

                case 0:
                    DealershipFileManager.saveDealership(dealership);
                    System.exit(0);

                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModel();
                    break;
                case 3:
                    processGetByYear();
                    break;
                case 4:
                    processGetByColor();
                    break;
                case 5:
                    processByGettingByMileage();
                    break;
                case 6:
                    processGetByVehicleType();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option");
            }
            scanner.close();
        }


    }

    public void processGetByPriceRequest() {
        boolean isGettingByPrice = true;

        while (isGettingByPrice) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter minimum price range: ");
                double minPrice = scanner.nextDouble();
                System.out.println("Enter maximum price range: ");
                double maxPrice = scanner.nextDouble();

                if (minPrice < maxPrice) {
                    System.out.printf("Results:%d and %d", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehicleList);
                    isGettingByPrice = false;

                }
                else{
                    System.out.println("min rice can not be greater than the max price");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Input error!");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }

    }

    public void processGetByMakeModel() {
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the make and model of vehicle desired: ");
                String make = scanner.nextLine();
                String model = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                isGettingByMakeModel = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");
            }
        }
    }

    public void processGetByYear() {
        boolean isGettingByYear = true;

        while (isGettingByYear) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter minimum year of desired vehicle: ");
                int minYear = scanner.nextInt();
                System.out.println("Enter maximum year of desired vehicle: ");
                int maxYear = scanner.nextInt();

                if (minYear <= maxYear) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehicleList);
                    isGettingByYear = false;

                }
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");

            }


        }

    }

    public void processGetByColor() {
        boolean isGettingColor = true;

        while (isGettingColor) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the desired color of vehicle: ");
                String color = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehicleByColor(color);
                displayVehicles(vehicleList);
                isGettingColor = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");
            }
        }
    }

    public void processByGettingByMileage() {
        boolean isGettingByMileage = true;

        while (isGettingByMileage) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter minimum desired mileage: ");
                int minMileage = scanner.nextInt();
                System.out.println("Enter maximum desired mileage: ");
                int maxMileage = scanner.nextInt();

                if (minMileage <= maxMileage) {
                    List<Vehicle> vehicleList = dealership.getVehicleByMileage(minMileage, maxMileage);
                    displayVehicles(vehicleList);
                    isGettingByMileage = false;
                } else {
                    System.out.println("Invalid input!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");
            }
        }


    }

    public void processGetByVehicleType() {
        boolean isGettingVehicleType = true;

        while (isGettingVehicleType) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter desired vehicle body type");
                String vehicleType = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehicleByType(vehicleType);
                displayVehicles(vehicleList);
                isGettingVehicleType = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");

            }


        }
    }

    public void processAddVehicleRequest() {

        boolean isAddingVehicle = true;

        while (isAddingVehicle) {
            try {

                System.out.println("Please enter the following information.");

                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter VIN: ");
                int vin = scanner.nextInt();

                System.out.print("Enter vehicle year: ");
                int year = scanner.nextInt();

                System.out.print("Enter vehicle make: ");
                String make = scanner.nextLine();

                System.out.print("Enter vehicle model: ");
                String model = scanner.nextLine();

                System.out.print("Enter vehicle body type: ");
                String vehicleType = scanner.nextLine();

                System.out.print("Enter the vehicle color: ");
                String color = scanner.nextLine();

                System.out.print("Enter the vehicle's odometer: ");
                int odometer = scanner.nextInt();

                System.out.print("Enter the vehicle's price: ");
                double price = scanner.nextDouble();

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(newVehicle);
                System.out.println("New vehicle added successfully!\n");
                isAddingVehicle = false;
            } catch (InputMismatchException ex) {
                System.out.println("Input error!");
            }
        }
    }


    private void processRemoveVehicleRequest() {
            System.out.println("Please enter the VIN of the vehicle you want to remove:");
            Scanner scanner = new Scanner(System.in);
            int vinToRemove = scanner.nextInt();

            List<Vehicle> inventory = dealership.getAllVehicles();
            boolean removed = false;

            for (Vehicle vehicle : inventory) {
                if (vehicle.getVin() == vinToRemove) {
                    dealership.removeVehicle(vehicle);
                    removed = true;
                    break;
                }
            }

            if (removed) {
                System.out.println("Vehicle with VIN " + vinToRemove + " has been removed from the inventory.\n");
            } else {
                System.out.println("No vehicle found with VIN " + vinToRemove + " in the inventory.\n");


        }

    }
    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }




}








