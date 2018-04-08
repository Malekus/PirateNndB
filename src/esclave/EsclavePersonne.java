package esclave;

import java.io.PrintWriter;
import java.util.Date;

import modele.Gestionnaire;
import modele.Personne;
import xml.ListePersonne;
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
			XMLPirateNndB.ecriture(new ListePersonne(), "personne");
			getOut().println("Vous avez creer une personne");
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				for(Personne p : Gestionnaire.ToutesLesPersonnes) {
					getOut().println(p);
				}
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
					getOut().println("L'attribut selectionn� n'existe pas ");
				} else {
					XMLPirateNndB.ecriture(new ListePersonne(), "personne");
					getOut().println("Vous avez modifi� une personne");
					getOut().println(personne);
				}

			} else {
				getOut().println("Cette personne n'existe pas");
			}

		}
			break;
		case "<Supprimer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			if (personne != null) {
				Gestionnaire.ToutesLesPersonnes.removeIf(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3])));
				XMLPirateNndB.ecriture(new ListePersonne(), "personne");
				getOut().println("Vous avez supprim� une personne");
			} else {
				getOut().println("Cette personne n'existe pas");
			}
		}
			break;

		default: {
			getOut().println("Aucun commande associ�e" + getClass());
		}
			break;
		}
	}
}
