package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

	public Object getters(String attr) {
		Method method;
		try {
			method = this.getClass().getMethod("get" + attr.substring(0, 1).toUpperCase() + attr.substring(1), null);
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

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Gestionnaire.initialisation();
		System.out.println(Gestionnaire.ToutesLesPersonnes.get(1).getters("eudo"));
		Gestionnaire.ToutesLesPersonnes.get(1).setters("Pseudo", "hannnaee");
		System.out.println(Gestionnaire.ToutesLesPersonnes.get(1).getters("Pseudo"));
	}

}
