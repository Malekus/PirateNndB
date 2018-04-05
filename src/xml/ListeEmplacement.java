package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import modele.Emplacement;
import modele.Logement;

@XmlRootElement
public class ListeEmplacement {


		private ArrayList<Emplacement> Emplacements;

		public ListeEmplacement() {
		}

		public ListeEmplacement(ArrayList<Emplacement> emplacements) {
			Emplacements = emplacements;
		}

		public ArrayList<Emplacement> getEmplacements() {
			return Emplacements;
		}

		public void setEmplacements(ArrayList<Emplacement> emplacements) {
			Emplacements = emplacements;
		}

		@Override
		public String toString() {
			return "ListeEmplacement [Emplacements=" + Emplacements + "]";
		}

		
		
		
}
