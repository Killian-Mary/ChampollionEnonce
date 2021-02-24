package champollion;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {

	private ArrayList<ServicePrevu> enseignements;
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.enseignements = new ArrayList<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        
    	int heuresPrevues = 0;
    	for(int i = 0; i < this.enseignements.size(); i++) {
    		int heuresCM = this.enseignements.get(i).getVolumeCM();
    		int heuresTD = this.enseignements.get(i).getVolumeTD();
    		int heuresTP = this.enseignements.get(i).getVolumeTP();
    		int heuresTotalesEquivalentTD = (int) (heuresCM*1.5 + heuresTP*0.75 + heuresTD);
     		heuresPrevues += heuresTotalesEquivalentTD;
    	}
    	
    	return heuresPrevues;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {

    	int heuresPrevuesPourUE = 0;
    	
    	for(int i = 0; i < this.enseignements.size(); i++) {
    		if(this.enseignements.get(i).getUe() == ue) {
    			int heuresCM = this.enseignements.get(i).getVolumeCM();
        		int heuresTD = this.enseignements.get(i).getVolumeTD();
        		int heuresTP = this.enseignements.get(i).getVolumeTP();
        		int heuresTotalesEquivalentTD = (int) (heuresCM*1.5 + heuresTP*0.75 + heuresTD);
        		heuresPrevuesPourUE += heuresTotalesEquivalentTD;
    		}    		
    	}
    	
	return heuresPrevuesPourUE;
    	
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) throws IllegalArgumentException{
        
    	// On vérifie que les volumes horaires sont corrects
    	if(volumeCM < 0 || volumeTD < 0 || volumeTP < 0) {
    		throw new IllegalArgumentException("Un des volumes horaires entrés n'est pas valable (inférieur à 0)");
    	}
    	
    	ServicePrevu sp = new ServicePrevu(ue, this, volumeCM, volumeTD, volumeTP);
    	this.enseignements.add(sp);
    	ue.getIntervenants().add(sp);
    }
    
    /**
     * Permet de savoir si un enseignant est en service "normal" ou en sous-service
     * Sachant qu'un service est "normal" à partir de 192h en équivalent TD
     * 
     * @return true si l'enseignant est en sous-service // false s'il est en service "normal"
     */
    public boolean enSousService() {
    	int heuresTotales = this.heuresPrevues();
    	
    	if(heuresTotales >= 192) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

}
