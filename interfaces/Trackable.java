package Java.Nutter_Tools.interfaces;
import models.ConstructionSite;

public interface Trackable {
    void assignToSite(ConstructionSite site);
    ConstructionSite getCurrentLocation();
}
