package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Regle {
	private boolean fumeur;
	private boolean animaux;
	private boolean fete;
	private Date dateArrive;
	private Date dateDepart;

	public Regle() {
	}

	public Regle(boolean fumeur, boolean animaux, boolean fete, Date dateArrive, Date dateDepart) {
		this.fumeur = fumeur;
		this.animaux = animaux;
		this.fete = fete;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
	}

	public boolean isFumeur() {
		return fumeur;
	}

	public void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}

	public boolean isAnimaux() {
		return animaux;
	}

	public void setAnimaux(boolean animaux) {
		this.animaux = animaux;
	}

	public boolean isFete() {
		return fete;
	}

	public void setFete(boolean fete) {
		this.fete = fete;
	}

	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Override
	public String toString() {
		return "Regle [fumeur=" + fumeur + ", animaux=" + animaux + ", fete=" + fete + ", dateArrive=" + dateArrive
				+ ", dateDepart=" + dateDepart + "]";
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
