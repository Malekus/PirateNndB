package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Commentaire {
	private Personne personne;
	private Date dateCommentaire;
	private String texte;

	public Commentaire() {
	}
	
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

	@Override
	public String toString() {
		return "Commentaire [personne=" + personne + ", dateCommentaire=" + dateCommentaire + ", texte=" + texte + "]";
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
