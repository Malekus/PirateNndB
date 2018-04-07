package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Logement {
	private int numero;
	private Personne hote;
	private ArrayList<Equipement> equipements;
	private Emplacement lieu;
	private ArrayList<Commentaire> commentaires;
	private boolean disponibilite;
	private float prix;

	public Logement(int numero, Personne hote, Emplacement lieu, boolean disponibilite, float prix) {
		this.numero = numero;
		this.hote = hote;
		this.equipements = new ArrayList<Equipement>();
		this.lieu = lieu;
		this.commentaires = new ArrayList<Commentaire>();
		this.disponibilite = disponibilite;
		this.prix = prix;
	}

	public Logement() {
		this.numero = 0;
		this.hote = null;
		this.equipements = new ArrayList<Equipement>();
		this.lieu = null;
		this.commentaires = new ArrayList<Commentaire>();
		this.disponibilite = true;
		this.prix = 0;
	}

	public Personne getHote() {
		return hote;
	}

	public void setHote(Personne hote) {
		this.hote = hote;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
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
		String r = "<logement>\n";
		r += "\t<numero>" + getNumero() + "</numero>\n";
		r += "\t<personne>" + getNumero() + "</personne>\n";
		if (getEquipements().isEmpty()) {
			r += "\t<equipements>\n\t</equipements>\n";
		} else {
			r += "\t<equipements>\n";
			for (Equipement e : getEquipements()) {
				r += "\t\t<equipement>" + e.toString() + "</equipement>\n";
			}
			r += "</equipements>\n";
		}
		r += "\t<lieu>" + getLieu() + "</lieu>\n";
		if (getCommentaires().isEmpty()) {
			r += "\t<commentaires>\n\t</commentaires>\n";
		} else {
			r += "\t<commentaires>\n";
			for (Commentaire c : getCommentaires()) {
				r += "\t\t<commentaire>" + c.toString() + "</commentaire>\n";
			}
			r += "</commentaires>\n";
		}
		r += "\t<disponibilite>" + getDisponibilite() + "</disponibilite>\n";
		r += "\t<prix>" + getPrix() + "</prix>\n</logement>";

		return r;
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
