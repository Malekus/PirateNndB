package modele;

public class Emplacement {
	private String adresse;
	private String ville;
	private String region;
	private String pays;

	public Emplacement(String adresse, String ville, String region, String pays) {
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.pays = pays;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Emplacement [adresse=" + adresse + ", ville=" + ville + ", region=" + region + ", pays=" + pays + "]";
	}

}
