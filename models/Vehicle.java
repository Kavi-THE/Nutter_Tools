package Java.Nutter_Tools.models;


import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private String vehicleId;
    private String model;
    private String status; 
    private double totalHoursOrKm;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.status = "Available";
        this.totalHoursOrKm = 0.0;
    }

    
    public abstract double calculateCost();

    
    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalHoursOrKm() { return totalHoursOrKm; }
    public void addUsage(double amount) { this.totalHoursOrKm += amount; }

    @Override
    public String toString() {
        return "ID: " + vehicleId + " | Model: " + model + " | Status: " + status + " | Usage: " + totalHoursOrKm;
    }
}