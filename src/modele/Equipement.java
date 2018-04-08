package modele;

public enum Equipement {
	laveLigne("Lave-ligne"), wifi("Wi-Fi"), television("T�l�vision"), ferArepasser("Fer � repasser"), chauffage(
			"Chauffage"), eauChaude("Eau chaude"), climatisation("Climatisation");

	private String name = "";

	Equipement(String equipement) {
		this.name = equipement;
	}

	public String toString() {
		return "<equipement>"+getName()+"</equipement>\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
