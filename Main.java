import models.*;
import managers.FleetManager;
import exceptions.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FleetManager fleetManager = new FleetManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Construction Fleet Management ---");
            System.out.println("1. Add Heavy Machinery");
            System.out.println("2. Assign Vehicle to Site");
            System.out.println("3. Log Daily Operation");
            System.out.println("4. Calculate Vehicle Payments");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            String choice = scanner.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("ID: "); String id = scanner.nextLine();
                    System.out.print("Model: "); String model = scanner.nextLine();
                    System.out.print("Initial Fuel (Liters): "); double fuel = Double.parseDouble(scanner.nextLine());
                    System.out.print("Hourly Rate (Rs.): "); double rate = Double.parseDouble(scanner.nextLine());
                    fleetManager.addVehicle(new HeavyMachinery(id, model, fuel, rate));
                    System.out.println("Vehicle Added.");

                } else if (choice.equals("2")) {
                    System.out.print("Vehicle ID: "); String id = scanner.nextLine();
                    Vehicle v = fleetManager.getVehicle(id);
                    if (v != null) {
                        System.out.print("Site Name: "); String siteName = scanner.nextLine();
                        v.assignToSite(new ConstructionSite(siteName));
                        fleetManager.saveChanges();
                        System.out.println("Assigned successfully.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }

                } else if (choice.equals("3")) {
                    System.out.print("Vehicle ID: "); String id = scanner.nextLine();
                    Vehicle v = fleetManager.getVehicle(id);
                    if (v != null) {
                        System.out.print("Date (YYYY-MM-DD): "); String date = scanner.nextLine();
                        System.out.print("Hours Worked: "); double hours = Double.parseDouble(scanner.nextLine());
                        System.out.print("Fuel Consumed (Liters): "); double fuel = Double.parseDouble(scanner.nextLine());
                        v.logOperation(date, hours, fuel);
                        fleetManager.saveChanges();
                        System.out.println("Operation logged.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }

                } else if (choice.equals("4")) {
                    System.out.print("Vehicle ID: "); String id = scanner.nextLine();
                    Vehicle v = fleetManager.getVehicle(id);
                    if (v != null) {
                        System.out.println("Total Payment Due: Rs." + v.calculatePayment());
                    }

                } else if (choice.equals("5")) {
                    fleetManager.saveChanges();
                    System.out.println("Data saved. Exiting...");
                    break;
                }
            } catch (InsufficientFuelException | VehicleNotAvailableException e) {
                System.out.println("Business Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input Error: Please enter a valid number.");
            }
        }
        scanner.close();
    }
}