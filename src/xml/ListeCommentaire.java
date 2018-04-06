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
<<<<<<< HEAD
=======
	
>>>>>>> 154e5f78fd0a28a39e4387ac7f7b07fb8bd38bda

}
