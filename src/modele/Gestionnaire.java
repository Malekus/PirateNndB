package modele;

import java.util.ArrayList;
import java.util.Date;

public class Gestionnaire {
	public static ArrayList<Personne> ToutesLesPersonnes = new ArrayList<Personne>();
	public static ArrayList<Logement> TousLesLogements = new ArrayList<Logement>();
	
	public static void initialisation() {
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Kader", "Commentaire 3", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Nafise", "FiaseNA", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Hannae", "Je parle pour rien", 6, new Date()));
		Gestionnaire.ToutesLesPersonnes.add(new Personne("Pseudo54", "ptotodz dz dazd", 6, new Date()));
		Gestionnaire.TousLesLogements.add(new Logement(Gestionnaire.ToutesLesPersonnes.get(2), new Emplacement("8 rue toto","Paris","Ile-de-france","France"), new Disponibilite(), 546));
	}

}
