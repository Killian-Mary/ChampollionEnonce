package champollion;

import java.util.ArrayList;
import java.util.List;

public class UE {
    private final String myIntitule;
    private ArrayList<ServicePrevu> intervenants;

    public UE(String intitule) {
        myIntitule = intitule;
        this.intervenants = new ArrayList<>();
    }

    public String getIntitule() {
        return myIntitule;
    }

    public List<ServicePrevu> getIntervenants(){
    	return this.intervenants;
    }
    
}
