package Nutter_Tools.models;
import java.io.Serializable;

public class OperationLog implements Serializable {
    private String date;
    private double hoursWorked;
    private double fuelconsumed;

    public OperationLog(String date, double hoursWorked, double fuelConsumed){
        this.date = date;
        this.hoursWorked = hoursWorked;
        this.fuelconsumed = fuelConsumed;
    }

    public double getHoursWorked()  { return hoursWorked; }
    public double getFuelConsumed() { return fuelconsumed; }    
    
    
}
