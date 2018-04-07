package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personne {
	private String pseudo;
	private String description;
	private int nbCommentaire;
	private Date dateInscription;

	private ArrayList<Langue> langues;

	public Personne() {
		this.pseudo = null;
		this.description = null;
		this.nbCommentaire = 0;
		this.dateInscription = null;
		this.langues = new ArrayList<Langue>();
	}

	public Personne(String pseudo, String description, int nbCommentaire, Date dateInscription) {
		this.pseudo = pseudo;
		this.description = description;
		this.nbCommentaire = nbCommentaire;
		this.dateInscription = dateInscription;
		this.langues = new ArrayList<Langue>();
	}

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
		String r = "\n<personne>\n";
		r += "\t<pseudo>" + getPseudo() + "</pseudo>\n";
		r += "\t<description>" + getDescription() + "</description>\n";
		r += "\t<nbCommentaire>" + getNbCommentaire() + "</nbCommentaire>\n";
		r += "\t<dateInscription>" + getDateInscription() + "</dateInscription>\n";
		r += "\t<langues>\n";

		if (getLangues().size() == 0) {
			r += "\t</langues>\n</personne>\n";
			return r;
		}

		for (Langue l : getLangues()) {
			r += "\t\t" + l.toString();
		}

		r += "\t</langues>\n</personne>\n";

		return r;
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

	public Object getters(String attr) {
		try {
			Method method = this.getClass().getMethod("get" + attr.substring(0, 1).toUpperCase() + attr.substring(1),
					null);
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

	public boolean setters(String attr, Object param) {
		String functionName = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1);
		Method method;
		boolean define = true;
		try {
			define = Arrays.asList(this.getClass().getMethods()).stream()
					.anyMatch(m -> m.getName().equals(functionName));
			if (!define)
				return define;

			method = this.getClass().getMethod(functionName, param.getClass());
			Object objet = method.invoke(this, param);

		} catch (NoSuchMethodException e) {
			System.err.println(e.getMessage());
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
		return define;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Gestionnaire.initialisation();
		System.out.println(Gestionnaire.ToutesLesPersonnes.get(1).getters("eudo"));
		Gestionnaire.ToutesLesPersonnes.get(1).setters("Pseudo", "hannnaee");
		System.out.println(Gestionnaire.ToutesLesPersonnes.get(1).getters("Pseudo"));
	}

}
