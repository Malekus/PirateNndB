package xml;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Personne;

@XmlRootElement
public class ListePersonne {
	private ArrayList<Personne> personnes;

	public ListePersonne() {
		this.personnes = new ArrayList<Personne>();
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

	@Override
	public String toString() {
		String r = "<ListePersonne>\n";
		for (Personne p : this.getPersonnes()) {
			r += "\t<Personne>" + "\n\t\t<pseudo>" + p.getPseudo() + "</pseudo>" + "\n\t\t<description>"
					+ p.getDescription() + "</description>" + "\n\t\t<nbCommentaire>" + p.getNbCommentaire()
					+ "</nbCommentaire>" + "\n\t</Personne>\n";
		}
		return r += "</ListePersonne>\n";
	}

	public String rechercher(ArrayList<String> params) {
		ListePersonne lp = new ListePersonne();
		ArrayList<Personne> resultat = getPersonnes();
		for (String s : params) {
			lp.getPersonnes().clear();
			String attr = s.split("-")[0];
			String param = s.split("-")[1];
			List personne = resultat.stream().filter(p -> p.getters(attr).equals(param)).collect(Collectors.toList());
			if (!personne.isEmpty()) {
				for (int i = 0; i < personne.size(); i++) {
					lp.getPersonnes().add((Personne) personne.get(i));
				}
			}
			resultat = (ArrayList<Personne>) personne;

		}

		return lp.toString();
	}

}
