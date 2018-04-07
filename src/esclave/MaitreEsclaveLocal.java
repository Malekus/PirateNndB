package esclave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import modele.Gestionnaire;
import modele.Langue;
import modele.Personne;
import serveur.Serveur;

public class MaitreEsclaveLocal implements Runnable {
	private final Socket client;
	private final Serveur serveur;
	private BufferedReader lecture = null;
	private PrintWriter ecriture = null;
	private String first[];
	private boolean enCours = true;

	public MaitreEsclaveLocal(Socket client, Serveur serveur, String first[]) {
		this.client = client;
		this.serveur = serveur;
		this.first = first;
	}

	public MaitreEsclaveLocal(Socket client, Serveur serveur) {
		this.client = client;
		this.serveur = serveur;
		this.first = null;
	}

	public void run() {
		System.out.println("Connexion en Local");
		while (!getClient().isClosed()) {
			try {
				lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
				ArrayList<String> listeCommande = new ArrayList<String>();
				String ligne = lecture.readLine();
				while (!ligne.isEmpty()) {
					listeCommande.add(ligne);
					ligne = lecture.readLine();
				}

				ecriture = new PrintWriter(getClient().getOutputStream(), true);

				String commande[] = new String[listeCommande.size()];
				commande = listeCommande.toArray(commande);
				switch (listeCommande.get(1).replaceAll("\n", "").replaceAll("\t", "")) {

				case "<Personne>": {
					new EsclavePersonne(commande, ecriture);
				}
					break;
				case "<Logement>": {
					new EsclaveLogement(commande, ecriture);
				}
					break;
				case "<Commentaire>": {
					new EsclaveCommentaire(commande, ecriture);
				}
					break;
				case "<Emplacement>": {
					new EsclaveEmplacement(commande, ecriture);
				}
					break;

				default:
					ecriture.println("Aucun commande associé");
					break;
				}

				if (listeCommande.get(1).replaceAll("\n", "").replaceAll("\t", "").equals("<Quitter></Quitter>")) {
					getClient().close();
					Thread.sleep(1000);
				}

			} catch (IOException | InterruptedException e) {
				System.out.println(getClass());
				System.out.println(e.getMessage());
			}
		}

	}

	public Socket getClient() {
		return client;
	}

	public Serveur getServeur() {
		return serveur;
	}

}

/*
 * if (commande[0].equals("GET") && commande[0].equals("HTTP/1.1")) {
 * ecriture.println("HTTP/1.1 200\\r\\n\\n\"\r\n" +
 * "                                + \"<html><head>\"\r\n" +
 * "                                + \"<title>Test http</title></head><body></body></html>"
 * ); new MaitreEsclaveNavigateur(client, serveur); }
 * 
 * 
 */
