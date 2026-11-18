package models;
import java.io.Serializable;

public class ConstructionSite implements Serializable {
    private String siteName;

    public ConstructionSite(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() { return siteName; }
    
    @Override
    public String toString() { return siteName; }
}