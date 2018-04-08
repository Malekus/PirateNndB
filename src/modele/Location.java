package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Location {
	private int numero;
	private Personne personne;
	private Logement logement;

	public Location() {
		this.numero = 0;
		this.personne = null;
		this.logement = null;
	}

	public Location(int numero, Personne personne, Logement logement) {
		this.numero = numero;
		this.personne = personne;
		this.logement = logement;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	@Override
	public String toString() {
		String r = "<location>\n";
		r += "\t<numero>" + getNumero() + "</numero>\n";
		r += "\t<personne>\n\t\t<pseudo>" + getPersonne().getPseudo() + "</pseudo>\n\t\t<description>"
				+ getPersonne().getDescription() + "</description>\n\t\t<nbCommentaire>"
				+ getPersonne().getNbCommentaire() + "</nbCommentaire>\n\t\t<dateInscription>"
				+ getPersonne().getDateInscription() + "</dateInscription>";
		if (getPersonne().getLangues().size() == 0) {
			r += "\n\t\t<langues>\n\t\t</langues>\n\t</personne>\n";
		} else {
			r += "\n\t\t<langues>\n";
			for (Langue l : getPersonne().getLangues()) {
				r += "\t\t\t" + l.toString();
			}
			r += "\t\t</langues>\n\t</personne>\n";
		}

		r += "\t<logement>\n";
		r += "\t\t<numero>" + getLogement().getNumero() + "</numero>\n";
		r += "\t\t<hote>\n";
		r += "\t\t\t<pseudo>" + getLogement().getHote().getPseudo() + "</pseudo>\n\t\t\t<description>"
				+ getLogement().getHote().getDescription() + "</description>\n\t\t\t<nbCommentaire>"
				+ getLogement().getHote().getNbCommentaire() + "</nbCommentaire>\n\t\t\t<dateInscription>"
				+ getLogement().getHote().getDateInscription() + "</dateInscription>";
		if (getPersonne().getLangues().size() == 0) {
			r += "\n\t\t<langues>\n\t\t</langues>\n";
		} else {
			r += "\n\t\t\t<langues>\n";
			for (Langue l : getPersonne().getLangues()) {
				r += "\t\t\t\t" + l.toString();
			}
			r += "\t\t\t</langues>\n";
		}
		r += "\t\t</hote>\n";
		r += "\t\t<equipements>\n";
		r += "\t\t</equipements>\n";
		r += "\t\t<lieu>\n";
		r += "\t\t</lieu>\n";
		r += "\t\t<commentaires>\n";
		r += "\t\t</commentaires>\n";
		r += "\t\t<disponibilite>" + getLogement().getDisponibilite() + "</disponibilite>\n";
		r += "\t\t<prix>" + getLogement().getPrix() + "</prix>\n";
		r += "\t</logement>";

		return r + "\n</location>\n";
	}

	public static void main(String[] args) {
		Gestionnaire.initialisation();
		System.out.println(Gestionnaire.ToutesLesLocations.get(0));
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

}
