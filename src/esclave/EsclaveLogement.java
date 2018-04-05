package esclave;

import java.io.PrintWriter;

public class EsclaveLogement extends Esclave{
	public EsclaveLogement(String requete[], PrintWriter out) {
		super(requete, out);
		traintement();
	}
	
	public void traintement() {
		for(String e : getRequete()) {
			System.out.println(e);
		}
		
		getOut().println("Tu as voulu creer un logement ??");
	}
}
