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

	public void run() {
		System.out.println("Connexion en Local");
		while (!client.isClosed()) {
			try {
				String commande[];
				if(this.first != null) {
					commande = this.first;
					this.first = null;
				}else {
					lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
					ecriture = new PrintWriter(getClient().getOutputStream(), true);
					commande = lecture.readLine().split(" ");
				}
				
				System.out.println(commande[0]);
				
				switch (commande[0].toUpperCase()) {

				case "PERSONNE": {
					new EsclavePersonne(commande, ecriture);
				}
					break;
				case "LOGEMENT": {
					new EsclaveLogement(commande, ecriture);
				}
					break;
				case "COMMENTAIRE": {
					new EsclaveCommentaire(commande, ecriture);
				}
					break;
				case "EMPLACEMENT": {
					new EsclaveEmplacement(commande, ecriture);
				}
					break;

				default:
					ecriture.println("Aucun commande associ�e");
					break;
				}

				if (commande[0].equals("FIN")) {
					ecriture.println("Vous vous etes d�connect�");
					getClient().close();
				}
			} catch (IOException e) {
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
