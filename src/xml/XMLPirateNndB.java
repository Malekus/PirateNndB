package xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modele.Gestionnaire;

public class XMLPirateNndB {

	public static void main(String[] args) {
		Gestionnaire.initialisation();		
		ecriture(new ListePersonne(), "personne");
		System.out.println(lecture(new ListePersonne(), "personne"));
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

	public static String lecture(Object obj, String filename) {
		String r = "";
		try {
			File file = new File("Sauvegarde/" + filename + ".xml");
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(obj.getClass());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object o = (Object) jaxbUnmarshaller.unmarshal(file);
			return o.toString();
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
		return r;

	}

	public static void supprimer(Object obj, String filename) {
		
	}

	public static void ajouter(Object obj, String filename) {

	}

	public static void rechercher(Object obj, String filename, ArrayList<String> params) {
		String recherche = "";
		if(filename.equals("personne")) {
			ListePersonne lp = (ListePersonne) obj;
			recherche = lp.rechercher(params);
			System.out.println(recherche);
		}
	}
	
	public static String getValue(String s) {
		return s.replace("\t", "").replaceAll("\n", "").split(">")[1].split("</")[0];
	}

}
