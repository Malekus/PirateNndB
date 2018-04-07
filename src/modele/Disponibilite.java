package modele;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Disponibilite {
	private boolean disponible = true;
	private Date debut;
	private Date fin;
	
	public Disponibilite() {
		this.debut = null;
		this.fin = null;
	}
	
	public void liberer() {
		this.setDisponible(true);
		this.setDebut(null);
		this.setFin(null);
	}
	
	public void occuper(Date debut, Date fin) {
		this.setDisponible(false);
		this.setDebut(debut);
		this.setFin(fin);
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
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
