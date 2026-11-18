package models;

public class HeavyMachinery extends Vehicle {
    private double hourlyRate;

    public HeavyMachinery(String vehicleId, String model, double initialFuel, double hourlyRate) {
        super(vehicleId, model, initialFuel);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getBaseRate() {
        return hourlyRate;
    }
}