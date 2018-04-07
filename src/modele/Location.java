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
		return "Location [personne=" + personne + ", logement=" + logement + "]";
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
