package managers;
import models.Vehicle;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "fleet_data.ser";

    public static void saveFleet(List<Vehicle> fleet) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(fleet);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Vehicle> loadFleet() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Vehicle>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file. Starting fresh.");
            return new ArrayList<>();
        }
    }
}