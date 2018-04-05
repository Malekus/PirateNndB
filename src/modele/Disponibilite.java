package modele;

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
	
	
}
