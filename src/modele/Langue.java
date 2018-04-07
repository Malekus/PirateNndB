package modele;

public enum Langue {
	francais("Français"),
	anglais("Anglais"),
	espagnol("Espagnol");
	
	private String name = "";

	Langue(String langue){
		this.name = langue;
	}
	
	private Langue() {
	}
	
	public String toString() {
		return "<langue>"+getName()+"</langue>\n";
	}
	
	public String getName() {
		return name;
	}
}
