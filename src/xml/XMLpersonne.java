package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modele.Gestionnaire;

public class XMLpersonne {

	
	public static void toto(Object liste, String nom) {
		try {
			JAXBContext context = JAXBContext.newInstance(liste.getClass());
			Marshaller m;
			m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(liste, new File("Sauvegarde/"+nom+".xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Gestionnaire.initialisation();
		ListePersonne personnes = new ListePersonne(Gestionnaire.ToutesLesPersonnes);
		toto(personnes, "personnes");
		toto(personnes, "logement");
		System.out.println(personnes.getClass());
	}

	
}