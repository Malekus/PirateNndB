package modele;

import java.util.Date;

public class Commentaire {
	private Personne personne;
	private Date dateCommentaire;
	private String texte;

	public Commentaire(Personne personne, Date dateCommentaire, String commentaire) {
		this.personne = personne;
		this.dateCommentaire = dateCommentaire;
		this.texte = commentaire;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public void set(String attr, Object obj) {
		switch (attr) {
		case "personne":
			this.setPersonne((Personne) obj);
			break;
		case "dateCommentaire":
			this.setDateCommentaire((Date) obj);
			break;
		case "texte":
			this.setTexte((String) obj);
			break;

		default:
			break;
		}
	}

}
