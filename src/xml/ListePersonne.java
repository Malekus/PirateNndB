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
	private ArrayList<Personne> personne;

	public ListePersonne() {
		this.personne = new ArrayList<Personne>();
	}

	public ListePersonne(ArrayList<Personne> personne) {
		this.personne = personne;
	}

	public ArrayList<Personne> getPersonnes() {
		return personne;
	}

	public void setPersonnes(ArrayList<Personne> personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		String r = "<ListePersonne>\n";
		for (Personne p : this.getPersonnes()) {
			r += "<personnes>\r\n" + "<dateInscription>2018-04-07T00:00:50.289+02:00</dateInscription>\r\n"
					+ "<description>Je parle pour rien</description>\r\n" + "<nbCommentaire>6</nbCommentaire>\r\n"
					+ "<pseudo>" + p.getPseudo() + "</pseudo>\r\n" + "</personnes>";
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
