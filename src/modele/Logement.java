package modele;

import java.util.ArrayList;

public class Logement {
	private Personne hote;
	private ArrayList<Equipement> equipements;
	private Emplacement lieu;
	private ArrayList<Commentaire> commentaires;
	private Disponibilite disponibilite;
	private float prix;

	public Logement(Personne hote, Emplacement lieu, Disponibilite disponibilite, float prix) {
		this.hote = hote;
		this.equipements = new ArrayList<Equipement>();
		this.lieu = lieu;
		this.commentaires = new ArrayList<Commentaire>();
		this.disponibilite = disponibilite;
		this.prix = prix;
	}

	public Personne getHote() {
		return hote;
	}

	public void setHote(Personne hote) {
		this.hote = hote;
	}

	public ArrayList<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(ArrayList<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Emplacement getLieu() {
		return lieu;
	}

	public void setLieu(Emplacement lieu) {
		this.lieu = lieu;
	}

	public ArrayList<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Disponibilite getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Logement [hote=" + hote + ", equipements=" + equipements + ", lieu=" + lieu + ", commentaires="
				+ commentaires + ", disponibilite=" + disponibilite + ", prix=" + prix + "]";
	}

	public void set(String attr, Object obj) {
		switch (attr) {
		case "hote":
			this.setHote((Personne) obj);
			break;
		case "lieu":
			this.setLieu((Emplacement) obj);
			break;
		case "equipement":
			this.getEquipements().add((Equipement) obj);
			break;
		case "prix":
			this.setPrix((float) obj);
			break;
		case "disponible":
			this.setDisponibilite((Disponibilite) obj);
			break;
		case "commentaire":
			this.getCommentaires().add((Commentaire) obj);
			break;
		default:
			break;
		}
	}

}
