package xml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Gestionnaire;
import modele.Location;
import modele.Personne;

@XmlRootElement
public class ListeLocation {
	private ArrayList<Location> locations;

	public ListeLocation(ArrayList<Location> locations) {
		super();
		this.locations = locations;
	};

	public ListeLocation() {
		this.locations = Gestionnaire.ToutesLesLocations;
	}

	@Override
	public String toString() {
		String r = "<ListeLocation>\n";
		for (Location l : this.getLocations()) {
			r += l.toString() + "\n";
		}
		return r += "</ListeLocation>\n";
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	};

	public String rechercher(ArrayList<String> params) {
		ListeLocation lc = new ListeLocation();
		ArrayList<Location> resultat = getLocations();
		for (String s : params) {
			lc.getLocations().clear();
			String attr = s.split("-")[0];
			String param = s.split("-")[1];
			List location = resultat.stream().filter(p -> p.getters(attr).equals(param)).collect(Collectors.toList());
			if (!location.isEmpty()) {
				for (int i = 0; i < location.size(); i++) {
					lc.getLocations().add((Location) location.get(i));
				}
			}
			resultat = (ArrayList<Location>) location;
		}
		return lc.toString();
	}

}
