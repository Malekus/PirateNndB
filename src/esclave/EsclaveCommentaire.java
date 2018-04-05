package esclave;

import java.io.PrintWriter;

public class EsclaveCommentaire extends Esclave {
	public EsclaveCommentaire(String requete[], PrintWriter out) {
		super(requete, out);
		traintement();
	}
	
	public void traintement() {
		for(String e : getRequete()) {
			System.out.println(e);
		}
		
		getOut().println("Tu as voulu creer un Commentaire ??");
	}
}
