package modele;

public enum Langue {
	francais("Fran�ais"),
	anglais("Anglais"),
	espagnol("Espagnol");
	
	private String name = "";

	Langue(String langue){
		this.name = langue;
	}
	
	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return name;
	}
}
