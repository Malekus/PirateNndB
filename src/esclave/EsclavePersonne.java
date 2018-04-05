package esclave;

import java.io.PrintWriter;
import java.util.Date;

import modele.Gestionnaire;
import modele.Personne;

public class EsclavePersonne extends Esclave {
	public EsclavePersonne(String string[], PrintWriter out) {
		super(string, out);
		traintement();
	}

	public void traintement() {
		switch (getRequete()[1].toUpperCase()) {
		case "CREER": {
			Personne personne = new Personne(getRequete()[2], getRequete()[3], 0, new Date());
			Gestionnaire.ToutesLesPersonnes.add(personne);
			getOut().println("Vous avez creer une personne");
		}
			break;

		case "AFFICHER": {
			if (getRequete().length == 2) {
				getOut().println(Gestionnaire.ToutesLesPersonnes);
			} else {
				Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
						.filter(p -> p.getPseudo().equals(getRequete()[2])).findAny().orElse(null);
				;
				getOut().println(personne);
			}

		}
			break;

		case "MODIFIER": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(getRequete()[2])).findAny().orElse(null);
			;
			if(personne == null) {
				getOut().println("Cette personne n'existe pas !");
			}else{
				personne.set(getRequete()[3], getRequete()[4]);
				getOut().println("Personne modifié");
				getOut().println(personne);
			}
			

		}
			break;

		default: {
			getOut().println("Aucun commande associée");
		}
			break;
		}
	}
}
