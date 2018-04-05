package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modele.Gestionnaire;

public class XMLPiraterie {

	public static void main(String[] args) {
		Gestionnaire.initialisation();
		ListeLogement lg = new ListeLogement(Gestionnaire.TousLesLogements);
		ecriture(new ListePersonne(Gestionnaire.ToutesLesPersonnes), "personne");
		ecriture(lg, "logement");
	}
	
	

	public static void ecriture(Object obj, String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m;
			m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(obj, new File("Sauvegarde/"+filename+".xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void lecture(String file) {
	
		
	}
	
	public static void supprimer() {
		
	}
	
	public static void ajouter() {
		
	}
	
	public static void rechercher() {
		
	}

}
