package esclave;

import java.io.PrintWriter;

import modele.Emplacement;
import modele.Gestionnaire;
import modele.Logement;
import modele.Personne;
import xml.ListeLogement;
import xml.XMLPirateNndB;

public class EsclaveLogement extends Esclave {
	public EsclaveLogement(String requete[], PrintWriter out) {
		super(requete, out);
		traintement();
	}

	public void traintement() {
		switch (getRequete()[2].replace("\t", "").replace("\n", "")) {
		case "<Creer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			if (personne != null) {
				Logement logement = new Logement(Gestionnaire.TousLesLogements.size() + 1, personne,
						new Emplacement("", XMLPirateNndB.getValue(getRequete()[4]), ""), Boolean.parseBoolean(XMLPirateNndB.getValue(getRequete()[5])),
						Float.parseFloat(XMLPirateNndB.getValue(getRequete()[6])));
				Gestionnaire.TousLesLogements.add(logement);
				XMLPirateNndB.ecriture(new ListeLogement(), "logement");
				getOut().println("Vous avez creer une logement");
				System.out.println("- Creer Logement Succes");
			} else {
				getOut().println("Cette personne n'existe pas");
				System.out.println("- Creer Logement Echec");
			}
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				for (Logement l : Gestionnaire.TousLesLogements) {
					getOut().println(l);
				}
				System.out.println("Afficher Logement Succes");
			} else {
				Logement logement = Gestionnaire.TousLesLogements.stream()
						.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
						.findAny().orElse(null);
				if (logement != null) {
					getOut().println(logement);
					System.out.println("- Afficher Logement Succes");
				} else {
					getOut().println("Ce logement n'existe pas");
					System.out.println("- Afficher Logement Echec");
				}
			}

		}
			break;

		case "<Modifier>": {
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3]))).findAny()
					.orElse(null);
			if (logement != null) {
				boolean methodeDefine = logement.setters(XMLPirateNndB.getValue(getRequete()[4]),
						XMLPirateNndB.getValue(getRequete()[5]));
				if (!methodeDefine) {
					getOut().println("L'attribut selectionn� n'existe pas ");
					System.out.println("- Modifier Logement Echec");
				} else {
					XMLPirateNndB.ecriture(new ListeLogement(), "logement");
					getOut().println("Vous avez modifi� ce logement");
					getOut().println(logement);
					System.out.println("- Modifier Logement Succes");
				}

			} else {
				getOut().println("Ce logement n'existe pas");
				System.out.println("- Modifier Logement Echec");
			}

		}
			break;
		case "<Supprimer>": {
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3]))).findAny()
					.orElse(null);
			if (logement != null) {
				Gestionnaire.TousLesLogements
						.removeIf(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])));
				XMLPirateNndB.ecriture(new ListeLogement(), "logement");
				getOut().println("Vous avez supprim� ce logement");
				System.out.println("- Supprimer Logement Succes");
			} else {
				getOut().println("Ce logement n'existe pas");
				System.out.println("- Supprimer Logement Echec");
			}
		}
			break;

		default: {
			getOut().println("Aucun commande associ�e" + getClass());
			System.out.println("- Commande Logement inconnue");
		}
			break;
		}
	}
}
