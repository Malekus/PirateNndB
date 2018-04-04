package modele;

public enum Equipement {
	laveLigne("Lave-ligne"),
	wifi("Wi-Fi"),
	television("Télévision"),
	climatisation("Climatisation");
	
	private String name = "";

	Equipement(String equipement){
		this.name = equipement;
	}
	
	public String toString() {
		return this.name;
	}
}
