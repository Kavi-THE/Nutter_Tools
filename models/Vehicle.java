package models;
import interfaces.Payable;
import interfaces.Trackable;
import exceptions.InsufficientFuelException;
import exceptions.VehicleNotAvailableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle implements Payable, Trackable, Serializable {
    private String vehicleId;
    private String model;
    private String status; // "Available", "On-Site", "Maintenance"
    private double currentFuelLevel;
    private ConstructionSite currentLocation;
    private List<OperationLog> logs;

    public Vehicle(String vehicleId, String model, double initialFuel) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.status = "Available";
        this.currentFuelLevel = initialFuel;
        this.logs = new ArrayList<>();
    }

    public abstract double getBaseRate(); 

    @Override
    public double calculatePayment() {
        double totalHours = 0;
        for (OperationLog log : logs) {
            totalHours += log.getHoursWorked();
        }
        return totalHours * getBaseRate();
    }

    @Override
    public void assignToSite(ConstructionSite site) {
        this.currentLocation = site;
        this.status = "On-Site";
    }

    @Override
    public ConstructionSite getCurrentLocation() {
        return currentLocation;
    }

    public void logOperation(String date, double hours, double fuelUsed) throws InsufficientFuelException, VehicleNotAvailableException {
        if (!status.equals("On-Site")) {
            throw new VehicleNotAvailableException("Vehicle " + vehicleId + " must be assigned to a site before logging operations.");
        }
        if (currentFuelLevel < fuelUsed) {
            throw new InsufficientFuelException("Not enough fuel in " + vehicleId + ". Current: " + currentFuelLevel + ", Required: " + fuelUsed);
        }
        
        this.currentFuelLevel -= fuelUsed;
        logs.add(new OperationLog(date, hours, fuelUsed));
    }

    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getCurrentFuelLevel() { return currentFuelLevel; }
    public void addFuel(double amount) { this.currentFuelLevel += amount; }
}