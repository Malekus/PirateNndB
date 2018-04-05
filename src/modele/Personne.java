package modele;

import java.util.ArrayList;
import java.util.Date;

public class Personne {
	private String pseudo;
	private String description;
	private int nbCommentaire;
	private Date dateInscription;
	private ArrayList<Langue> langues;

	public Personne(String pseudo, String description, int nbCommentaire, Date dateInscription,
			ArrayList<Langue> langues) {
		this.pseudo = pseudo;
		this.description = description;
		this.nbCommentaire = nbCommentaire;
		this.dateInscription = dateInscription;
		this.langues = langues;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getDescription() {
		return description;
	}

	public int getNbCommentaire() {
		return nbCommentaire;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public ArrayList<Langue> getLangues() {
		return langues;
	}

	@Override
	public String toString() {
		return "Personne [pseudo=" + pseudo + ", description=" + description + ", nbCommentaire=" + nbCommentaire
				+ ", dateInscription=" + dateInscription + ", langues=" + langues + "]";
	}
	

}
