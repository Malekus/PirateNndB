package modele;

public enum Langue {
	francais("Français"),
	anglais("Anglais"),
	espagnol("Espagnol");
	
	private String name = "";

	Langue(String langue){
		this.name = langue;
	}
	
	public String toString() {
		return this.name;
	}
}
