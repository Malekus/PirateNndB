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
		switch (getRequete()[2].replace("\t", "").replace("\n", "")) {
		case "<Creer>": {
			Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
					.filter(p -> p.getPseudo().equals(XMLPirateNndB.getValue(getRequete()[3]))).findAny().orElse(null);
			Logement logement = Gestionnaire.TousLesLogements.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[4])))
					.findAny().orElse(null);
			if (personne != null && logement != null) {
				if(logement.getDisponibilite()) {
					logement.setDisponibilite(false);
					Location location = new Location(Gestionnaire.ToutesLesLocations.size() + 1, personne, logement);
					Gestionnaire.ToutesLesLocations.add(location);
					XMLPirateNndB.ecriture(new ListeLocation(), "location");
					getOut().println("Vous avez creer une location");
					System.out.println("- Creer Location Succes");
				}else {
					getOut().println("Ce logement est déjà loué");
					System.out.println("- Creer Location Echec");
				}
			} else {
				getOut().println("Cette personne/logement n'existe pas");
				System.out.println("- Creer Location Echec");
			}
		}
			break;

		case "<Afficher>": {
			if (getRequete()[3].contains("</Afficher>")) {
				for(Location l : Gestionnaire.ToutesLesLocations) {
					getOut().println(l);
				}
				System.out.println("- Afficher Location Succes");
			} else {
				Location location = Gestionnaire.ToutesLesLocations.stream()
						.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
						.findAny().orElse(null);
				if (location != null) {
					getOut().println(location);
					System.out.println("- Afficher Location Succes");
				} else {
					getOut().println("Cette location n'existe pas");
					System.out.println("- Afficher Location Echec");
				}
			}

		}
			break;

		case "<Modifier>": {
			Location location = Gestionnaire.ToutesLesLocations.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
					.findAny().orElse(null);
			if (location != null) {
				boolean methodeDefine = location.setters(XMLPirateNndB.getValue(getRequete()[4]),
						XMLPirateNndB.getValue(getRequete()[5]));
				if (!methodeDefine) {
					getOut().println("L'attribut selectionné n'existe pas ");
					System.out.println("- Modifier Location Echec");
				} else {
					XMLPirateNndB.ecriture(new ListeLocation(), "location");
					getOut().println("Vous avez modifié cette location");
					getOut().println(location);
					System.out.println("- Modifier Location Succes");
				}

			} else {
				getOut().println("Cette location n'existe pas");
				System.out.println("- Modifier Location Echec");
			}

		}
			break;
		case "<Supprimer>": {
			Location location = Gestionnaire.ToutesLesLocations.stream()
					.filter(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])))
					.findAny().orElse(null);
			if (location != null) {
				Gestionnaire.ToutesLesLocations
						.removeIf(l -> l.getNumero() == Integer.parseInt(XMLPirateNndB.getValue(getRequete()[3])));
				XMLPirateNndB.ecriture(new ListeLocation(), "location");
				getOut().println("Vous avez supprimé cette location");
				System.out.println("- Supprimer Location Succes");
			} else {
				getOut().println("Cette location n'existe pas");
				System.out.println("- Supprimer Location Echec");
			}
		}
			break;

		default: {
			getOut().println("Aucun commande associée");
			System.out.println("- Commande Location inconnue");
		}
			break;
		}
	}
}
