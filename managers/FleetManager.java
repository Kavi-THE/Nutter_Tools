package services;

import models.Vehicle;
import exceptions.FleetException;
import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public Vehicle findVehicle(String vehicleId) throws FleetException {
        for (Vehicle v : fleet) {
            if (v.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return v;
            }
        }
        throw new FleetException("Vehicle with ID " + vehicleId + " not found!");
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }
}