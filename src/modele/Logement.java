package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

	
	public Object getters(String attr) {
		try {
			Method method = this.getClass().getMethod("get" + attr.substring(0, 1).toUpperCase() + attr.substring(1), null);
			Object objet = method.invoke(this, null);
			return objet;
		} catch (NoSuchMethodException e) {
			System.err.println(e.getMessage());
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
		return new Object();
	}

	public void setters(String attr, Object param) {
		Method method;
		try {
			method = this.getClass().getMethod("set" + attr.substring(0, 1).toUpperCase() + attr.substring(1),
					param.getClass());
			Object objet = method.invoke(this, param);
		} catch (NoSuchMethodException e) {
			System.err.println(e.getMessage());
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
	}

}
