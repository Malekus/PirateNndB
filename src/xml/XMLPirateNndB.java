package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modele.Gestionnaire;

public class XMLPirateNndB {

	public static void main(String[] args) {
		Gestionnaire.initialisation();		
		ecriture(new ListePersonne(Gestionnaire.ToutesLesPersonnes), "personne");
		//System.out.println(lecture(new ListePersonne(), "personne"));
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
			Object xo = (Object) jaxbUnmarshaller.unmarshal(file);
			return xo.toString();
		} catch (JAXBException e) {
			System.out.println(e.getMessage());

		}
		return r;

	}

	public static void supprimer() {

	}

	public static void ajouter() {

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
