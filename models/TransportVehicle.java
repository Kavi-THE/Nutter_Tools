package models;

public class TransportVehicle extends Vehicle {
    private double ratePerTrip;

    public TransportVehicle(String vehicleId, String model, double initialFuel, double ratePerTrip) {
        super(vehicleId, model, initialFuel);
        this.ratePerTrip = ratePerTrip;
    }

    @Override
    public double getBaseRate() {
        // For simplicity in this structure, assuming 1 trip = 1 hour of logged time
        return ratePerTrip;
    }
}