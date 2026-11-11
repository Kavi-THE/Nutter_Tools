package Nutter_Tools.models;
import java.io.Serializable;


public class ConstructionSite implements serializable{
    private string siteName;

    public ConstructionSite(string siteName){
        this.siteName = siteName;
    
    }

    public string getsiteName(){ return siteName;}

    @Override 
    public String toString(){ return siteName;}

    
}
