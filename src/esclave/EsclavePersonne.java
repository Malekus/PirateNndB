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
			System.out.println("- Creer Personne Succes");
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				for(Personne p : Gestionnaire.ToutesLesPersonnes) {
					getOut().println(p);
				}
				System.out.println("- Afficher Personne Succes");
			} else {
				Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
						.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny()
						.orElse(null);
				if (personne != null) {
					getOut().println(personne);
					System.out.println("- Afficher Personne Succes");
				} else {
					getOut().println("Cette personne n'existe pas");
					System.out.println("- Afficher Personne Echec");
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
					System.out.println("- Modifier Personne Echec");
				} else {
					XMLPirateNndB.ecriture(new ListePersonne(), "personne");
					getOut().println("Vous avez modifié une personne");
					getOut().println(personne);
					System.out.println("- Modifier Personne Succes");
				}

			} else {
				getOut().println("Cette personne n'existe pas");
				System.out.println("- Modifier Personne Echec");
			}

		}
			break;
		case "<Supprimer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			if (personne != null) {
				Gestionnaire.ToutesLesPersonnes.removeIf(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3])));
				XMLPirateNndB.ecriture(new ListePersonne(), "personne");
				getOut().println("Vous avez supprimé une personne");
				System.out.println("- Supprimer Personne Succes");
			} else {
				getOut().println("Cette personne n'existe pas");
				System.out.println("- Supprimer Personne Echec");
			}
		}
			break;

		default: {
			getOut().println("Aucun commande associée");
			System.out.println("- Commande Personne inconnue");
		}
			break;
		}
	}
}
