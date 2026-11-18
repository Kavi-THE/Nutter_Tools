package models;
import java.io.Serializable;

public class OperationLog implements Serializable {
    private String date;
    private double hoursWorked;
    private double fuelConsumed;

    public OperationLog(String date, double hoursWorked, double fuelConsumed) {
        this.date = date;
        this.hoursWorked = hoursWorked;
        this.fuelConsumed = fuelConsumed;
    }

    public double getHoursWorked() { return hoursWorked; }
    public double getFuelConsumed() { return fuelConsumed; }
}
