package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import modele.Personne;

public class XMLpersonne {

	 public static void main(String[] args) {
		    try {
		    	File file = new File("Sauvegarde/personne.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(ListePersonne.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				ListePersonne personnes = (ListePersonne) jaxbUnmarshaller.unmarshal(file);
				System.out.println(personnes);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
}
	
