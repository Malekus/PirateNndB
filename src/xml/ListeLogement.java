package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Logement;

@XmlRootElement
public class ListeLogement {

	private ArrayList<Logement> logements;

	public ListeLogement() {
	}

	public ListeLogement(ArrayList<Logement> logements) {
		this.logements = logements;
	}

	public ArrayList<Logement> getLogements() {
		return logements;
	}

	public void setLogements(ArrayList<Logement> logements) {
		this.logements = logements;
	}

}
