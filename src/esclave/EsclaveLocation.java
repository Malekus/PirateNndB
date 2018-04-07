package esclave;

import java.io.PrintWriter;

public class EsclaveLocation extends Esclave{
	public EsclaveLocation(String requete[], PrintWriter out) {
		super(requete, out);
		traintement();
	}
	
	public void traintement() {
		for(String s : getRequete()) {
			System.out.println(s);
		}
		
		/*
		switch (getRequete()[2].replace("\t", "").replace("\n", "")) {
		case "<Creer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			if (personne != null) {
				Logement logement = new Logement(Gestionnaire.TousLesLogements.size() + 1, personne,
						new Emplacement("", "", ""), Boolean.parseBoolean(XMLPirateNndB.getValue(getRequete()[5])),
						Float.parseFloat(XMLPirateNndB.getValue(getRequete()[6])));
				Gestionnaire.TousLesLogements.add(logement);
				XMLPirateNndB.ecriture(new ListeLogement(), "logement");
				getOut().println("Vous avez creer une logement");
			} else {
				getOut().println("Cette personne n'existe pas");
			}
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				getOut().println(Gestionnaire.TousLesLogements);
			} else {
				Logement logement = Gestionnaire.TousLesLogements.stream()
						.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
						.findAny().orElse(null);
				if (logement != null) {
					getOut().println(logement);
				} else {
					getOut().println("Ce logement n'existe pas");
				}
			}

		}
			break;

		case "<Modifier>": {
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
					.findAny().orElse(null);
			if (logement != null) {
				boolean methodeDefine = logement.setters(XMLPirateNndB.getValue(getRequete()[4]),
						XMLPirateNndB.getValue(getRequete()[5]));
				if (!methodeDefine) {
					getOut().println("L'attribut selectionné n'existe pas ");
				} else {
					XMLPirateNndB.ecriture(new ListeLogement(), "logement");
					getOut().println("Vous avez modifié ce logement");
					getOut().println(logement);
				}

			} else {
				getOut().println("Ce logement n'existe pas");
			}

		}
			break;
		case "<Supprimer>": {
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
					.findAny().orElse(null);
			if (logement != null) {
				Gestionnaire.TousLesLogements
						.removeIf(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])));
				XMLPirateNndB.ecriture(new ListeLogement(), "logement");
				getOut().println("Vous avez supprimé ce logement");
			} else {
				getOut().println("Ce logement n'existe pas");
			}
		}
			break;

		default: {
			getOut().println("Aucun commande associée" + getClass());
		}
			break;
		}*/
	}
}
