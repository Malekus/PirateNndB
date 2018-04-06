package xml;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		for(Personne p : this.getPersonnes()) {
			r+= "\t<Personne>"
				+ "\n\t\t<pseudo>"+p.getPseudo()+"</pseudo>"
				+ "\n\t\t<description>"+p.getDescription()+"</description>"
				+ "\n\t\t<nbCommentaire>"+p.getNbCommentaire()+"</nbCommentaire>"
				+ "\n\t</Personne>\n";
		}		
		return r+= "</ListePersonne>\n";
	}
	
	public String rechercher(HashMap<String, Object> params) {
		ListePersonne lp = new ListePersonne();
		/*for (Map.Entry<String, Object> entry : params.entrySet()) {
			
		}*/
		Method m[] = Personne.class.getDeclaredMethods();
		for(Method x : m) {
			
			System.out.println(x);
		}
		System.out.println(Method.PUBLIC);
		
		return lp.toString();
	}
	
	
}
