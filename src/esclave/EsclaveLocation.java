package esclave;

import java.io.PrintWriter;

import modele.Gestionnaire;
import modele.Location;
import modele.Logement;
import modele.Personne;
import xml.ListeLocation;
import xml.ListeLogement;
import xml.XMLPirateNndB;

public class EsclaveLocation extends Esclave{
	public EsclaveLocation(String requete[], PrintWriter out) {
		super(requete, out);
		traintement();
	}
	
	public void traintement() {
		for(String s : getRequete()) {
			System.out.println(s);
		}
		
		
		switch (getRequete()[2].replace("\t", "").replace("\n", "")) {
		case "<Creer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
					.findAny().orElse(null);
			if (personne != null && logement != null) {
				if(logement.getDisponibilite()) {
					Location location = new Location(Gestionnaire.ToutesLesLocations.size() + 1, personne, logement);
					Gestionnaire.ToutesLesLocations.add(location);
					XMLPirateNndB.ecriture(new ListeLocation(), "location");
					getOut().println("Vous avez creer une location");
				}else {
					getOut().println("Ce logement est d�j� lou�");
				}
			} else {
				getOut().println("Cette personne/logement n'existe pas");
			}
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				getOut().println(Gestionnaire.ToutesLesLocations);
			} else {
				Location location = Gestionnaire.ToutesLesLocations.stream()
						.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
						.findAny().orElse(null);
				if (location != null) {
					getOut().println(location);
				} else {
					getOut().println("Cette logement n'existe pas");
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
					getOut().println("L'attribut selectionn� n'existe pas ");
				} else {
					XMLPirateNndB.ecriture(new ListeLogement(), "logement");
					getOut().println("Vous avez modifi� ce logement");
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
				getOut().println("Vous avez supprim� ce logement");
			} else {
				getOut().println("Ce logement n'existe pas");
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
