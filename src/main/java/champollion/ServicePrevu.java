package champollion;

public class ServicePrevu {
	
	private UE ue;
	private Enseignant enseignant;
	private int volumeCM;
	private int volumeTD;
	private int volumeTP;
	
	public ServicePrevu(UE ue, Enseignant enseignant, int volumeCM, int volumeTD, int volumeTP) {
		this.ue = ue;
		this.enseignant = enseignant;
		this.volumeCM = volumeCM;
		this.volumeTD = volumeTD;
		this.volumeTP = volumeTP;
	}

	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public int getVolumeCM() {
		return volumeCM;
	}

	public void setVolumeCM(int volumeCM) {
		this.volumeCM = volumeCM;
	}

	public int getVolumeTD() {
		return volumeTD;
	}

	public void setVolumeTD(int volumeTD) {
		this.volumeTD = volumeTD;
	}

	public int getVolumeTP() {
		return volumeTP;
	}

	public void setVolumeTP(int volumeTP) {
		this.volumeTP = volumeTP;
	}
	
	
	// TODO : implémenter cette classe

}
