package esclave;

import java.io.PrintWriter;
import java.util.Date;

import modele.Gestionnaire;
import modele.Personne;
import xml.XMLPirateNndB;

public class EsclavePersonne extends Esclave {
	public EsclavePersonne(String string[], PrintWriter out) {
		super(string, out);
		traintement();
	}

	public void traintement() {
		switch (getRequete()[2].replace("\t", "").replace("\n", "")) {
		case "<Creer>": {
			Personne personne = new Personne(XMLPirateNndB.getValue(getRequete()[3]),
					XMLPirateNndB.getValue(getRequete()[4]), 0, new Date());
			Gestionnaire.ToutesLesPersonnes.add(personne);
			getOut().println("Vous avez creer une personne");
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				getOut().println(Gestionnaire.ToutesLesPersonnes);
			} else {
				Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
						.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny()
						.orElse(null);
				if (personne != null) {
					getOut().println(personne);
				} else {
					getOut().println("Cette personne n'existe pas");
				}
			}

		}
			break;

		case "<Modifier>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			if (personne != null) {
				boolean methodeDefine = personne.setters(XMLPirateNndB.getValue(getRequete()[4]),
						XMLPirateNndB.getValue(getRequete()[5]));
				if (!methodeDefine) {
					getOut().println("L'attribut selectionné n'existe pas ");
				} else {
					getOut().println("Vous avez modifié une personne");
					getOut().println(personne);
				}

			} else {
				getOut().println("Cette personne n'existe pas");
			}

		}
			break;

		default: {
			getOut().println("Aucun commande associée" + getClass());
		}
			break;
		}
	}
}
