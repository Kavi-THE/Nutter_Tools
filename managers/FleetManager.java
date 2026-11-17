package managers;
import models.Vehicle;
import java.util.List;

public class FleetManager {
    private List<Vehicle> fleet;

    public FleetManager() {
        this.fleet = FileManager.loadFleet();
    }

    public void addVehicle(Vehicle v) {
        fleet.add(v);
        saveChanges();
    }

    public Vehicle getVehicle(String id) {
        for (Vehicle v : fleet) {
            if (v.getVehicleId().equalsIgnoreCase(id)) return v;
        }
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        return fleet;
    }

    public void saveChanges() {
        FileManager.saveFleet(fleet);
    }
}