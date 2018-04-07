package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Emplacement {
	private String adresse;
	private String ville;
	private String pays;

	public Emplacement(String adresse, String ville, String pays) {
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}

	public Emplacement() {
		this.adresse = null;
		this.ville = null;
		this.pays = null;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		String r = "<emplacement>\n";
		r += "\t<adresse>" + getAdresse() + "</adresse>\n";
		r += "\t<ville>" + getVille() + "</ville>\n";
		r += "\t<pays>" + getPays() + "</pays>\n</emplacement>\n";
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
