package modele;

import java.util.Date;

public class Commentaire {
	private Personne personne;
	private Date dateCommentaire;
	private String commentaire;

	public Commentaire(Personne personne, Date dateCommentaire, String commentaire) {
		this.personne = personne;
		this.dateCommentaire = dateCommentaire;
		this.commentaire = commentaire;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public void set(String attr, Object obj) {
		switch (attr) {
		case "personne":
			this.setPersonne((Personne) obj);
			break;
		case "dateCommentaire":
			this.setDateCommentaire((Date) obj);
			break;
		case "commentaire":
			this.setCommentaire((String) obj);
			break;

		default:
			break;
		}
	}

}
