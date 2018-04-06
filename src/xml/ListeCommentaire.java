package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import modele.Commentaire;

@XmlRootElement
public class ListeCommentaire {
	public ArrayList<Commentaire> lesCommentaires;

	public ListeCommentaire() {
		this.lesCommentaires = new ArrayList<Commentaire>();
	}

	public ListeCommentaire(ArrayList<Commentaire> commentaires) {
		this.lesCommentaires = commentaires;
	}

	@Override
	public String toString() {
		String r = "";
		for(Commentaire c : this.lesCommentaires) {
			
		}
		return r;
	}

}
