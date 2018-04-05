package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modele.Gestionnaire;

public class XMLPiraterie {

	public static void main(String[] args) {
		Gestionnaire.initialisation();
		ListeLogement lg = new ListeLogement(Gestionnaire.TousLesLogements);
		ListeEmplacement e = new ListeEmplacement(Gestionnaire.TousLesEmplacements);
		ecriture(new ListePersonne(Gestionnaire.ToutesLesPersonnes), "personne");
		ecriture(new ListeCommentaire(Gestionnaire.TousLesCommentaires), "commentaire");
		ecriture(lg, "logement");
		ecriture(e, "emplacement");
		lecture(new ListePersonne(), "personne");
		lecture(new ListeEmplacement(), "emplacement");
	}

	public static void ecriture(Object obj, String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m;
			m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(obj, new File("Sauvegarde/" + filename + ".xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void lecture(Object obj, String filename) {

		try {
			File file = new File("Sauvegarde/" + filename + ".xml");
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(obj.getClass());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object xo = (Object) jaxbUnmarshaller.unmarshal(file);
			System.out.println(xo);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void supprimer() {

	}

	public static void ajouter() {

	}

	public static void rechercher() {

	}

}
