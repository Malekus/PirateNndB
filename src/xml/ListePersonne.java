package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Personne;

@XmlRootElement
public class ListePersonne {
	private ArrayList<Personne> personnes;

	public ListePersonne() {
	}

	public ListePersonne(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}

	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}
	
	 
	
	
}
