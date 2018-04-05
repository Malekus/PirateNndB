package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import modele.Commentaire;

@XmlRootElement
public class ListeCommentaire {
	public ArrayList<Commentaire> lesCommentaires;

	public ListeCommentaire() {
	}

	public ListeCommentaire(ArrayList<Commentaire> commentaires) {
		this.lesCommentaires = commentaires;
	}

	public ArrayList<Commentaire> getLesCommentaires() {
		return lesCommentaires;
	}

	public void setLesCommentaires(ArrayList<Commentaire> lesCommentaires) {
		this.lesCommentaires = lesCommentaires;
	}
	
	

}
