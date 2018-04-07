package modele;

import java.util.ArrayList;
import java.util.Date;

public class Gestionnaire {
	public static ArrayList<Personne> ToutesLesPersonnes = new ArrayList<Personne>();
	public static ArrayList<Logement> TousLesLogements = new ArrayList<Logement>();
	public static ArrayList<Emplacement> TousLesEmplacements = new ArrayList<Emplacement>();
	public static ArrayList<Commentaire> TousLesCommentaires = new ArrayList<Commentaire>();

	
	public static void initialisation() {
		ArrayList<Langue> lg = new ArrayList<Langue>();
		lg.add(Langue.francais);
		lg.add(Langue.anglais);
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Kader", "Je parle pour rien", 6, new Date(), lg));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Nafise", "FiaseNA", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Hannae", "Je parle pour rien", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Pseudo54", "ptotodz dz dazd", 6, new Date()));
		Gestionnaire.TousLesLogements.add(new Logement(Gestionnaire.ToutesLesPersonnes.get(2), new Emplacement("8 rue toto","Paris","Ile-de-france","France"), new Disponibilite(), 546));
		Gestionnaire.TousLesEmplacements.add(new Emplacement("3 rue des nuages", "Paris", "Ile-de-France", "France"));
		Gestionnaire.TousLesEmplacements.add(new Emplacement("5 avenue Jean Jaures", "Toulouse", "Ile-de-France", "France"));
		Gestionnaire.TousLesCommentaires.add(new Commentaire(Gestionnaire.ToutesLesPersonnes.get(0), new Date(), "Bonjour j'habite ici"));

	}

}
