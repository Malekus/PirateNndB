package modele;

import java.util.ArrayList;
import java.util.Date;

public class Gestionnaire {
	public static ArrayList<Personne> ToutesLesPersonnes = new ArrayList<Personne>();
	public static ArrayList<Logement> TousLesLogements = new ArrayList<Logement>();
	public static ArrayList<Emplacement> TousLesEmplacements = new ArrayList<Emplacement>();
	public static ArrayList<Commentaire> TousLesCommentaires = new ArrayList<Commentaire>();
	public static ArrayList<Location> ToutesLesLocations = new ArrayList<Location>();

	public static void initialisation() {
		ArrayList<Langue> lg = new ArrayList<Langue>();
		lg.add(Langue.francais);
		lg.add(Langue.anglais);
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Kader", "Je parle pour rien", 6, new Date(), lg));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Nafise", "FiaseNA", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Hannae", "Je parle pour rien", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Pseudo54", "ptotodz dz dazd", 6, new Date()));

		Gestionnaire.TousLesEmplacements.add(new Emplacement("3 rue des nuages", "Paris", "France"));
		Gestionnaire.TousLesEmplacements.add(new Emplacement("5 avenue Jean Jaures", "Toulouse", "France"));
		Gestionnaire.TousLesEmplacements.add(new Emplacement("avenue Victor Hugo", "Lyon", "France"));
		Gestionnaire.TousLesEmplacements.add(new Emplacement("8 rue toto", "Paris", "France"));
		Gestionnaire.TousLesCommentaires
				.add(new Commentaire(Gestionnaire.ToutesLesPersonnes.get(0), new Date(), "Bonjour j'habite ici"));
		Gestionnaire.TousLesLogements.add(new Logement(1,Gestionnaire.ToutesLesPersonnes.get(3),
				Gestionnaire.TousLesEmplacements.get(2), true, 750));
		Gestionnaire.TousLesLogements.add(new Logement(3,Gestionnaire.ToutesLesPersonnes.get(2),
				Gestionnaire.TousLesEmplacements.get(3), true, 546));
		Gestionnaire.TousLesLogements.add(new Logement(2,Gestionnaire.ToutesLesPersonnes.get(1),
				Gestionnaire.TousLesEmplacements.get(2), true, 954));
		Gestionnaire.TousLesLogements.add(new Logement(4,Gestionnaire.ToutesLesPersonnes.get(0),
				Gestionnaire.TousLesEmplacements.get(3), true, 954));

	}

}
