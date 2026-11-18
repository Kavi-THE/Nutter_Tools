package Java.Nutter_Tools.models;
package models;

public class TransportVehicle extends Vehicle {
    private double ratePerTrip;

    public TransportVehicle(String vehicleId, String model, double initialFuel, double ratePerTrip) {
        super(vehicleId, model, initialFuel);
        this.ratePerTrip = ratePerTrip;
    }

    @Override
    public double getBaseRate() {
        return ratePerTrip;
    }
}