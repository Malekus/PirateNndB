package modele;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personne {
	private String pseudo;
	private String description;
	private int nbCommentaire;
	private Date dateInscription;
	private ArrayList<Langue> langues;

	public Personne() {
	}
	
	public Personne(String pseudo, String description, int nbCommentaire, Date dateInscription) {
		this.pseudo = pseudo;
		this.description = description;
		this.nbCommentaire = nbCommentaire;
		this.dateInscription = dateInscription;
		this.langues = new ArrayList<Langue>();
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

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNbCommentaire(int nbCommentaire) {
		this.nbCommentaire = nbCommentaire;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public void setLangues(ArrayList<Langue> langues) {
		this.langues = langues;
	}

	public void set(String attr, Object obj) {
		switch (attr) {
		case "pseudo":
			this.setPseudo((String) obj);
			break;
		case "description":
			this.setDescription((String) obj);
			break;
		case "nbCommentaire":
			this.setNbCommentaire((int) obj);
			break;
		case "dateInscription":
			this.setDateInscription(((Date) obj));
			break;
		case "langues":
			this.setLangues((ArrayList<Langue>) obj);
			break;
		default:
			break;
		}
	}

}
