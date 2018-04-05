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
	private boolean enCours = true;

	public MaitreEsclaveLocal(Socket client, Serveur serveur) {
		this.client = client;
		this.serveur = serveur;
	}

	public void run() {
		System.out.println("Connexion en Local");
		while (!client.isClosed()) {
			try {
				lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
				ecriture = new PrintWriter(getClient().getOutputStream(), true);
				String commande[] = lecture.readLine().split(" ");
				switch (commande[0].toUpperCase()) {
				case "CREER_PERSONNE": {
					Personne personne = new Personne(commande[1], commande[2], 0, new Date());
					Gestionnaire.ToutesLesPersonnes.add(personne);
					ecriture.println("Vous avez creer une personne");
				}
					break;

				case "AFFICHER_PERSONNE": {
					if (commande.length == 1) {
						ecriture.println(Gestionnaire.ToutesLesPersonnes);
					} else {
						Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
								.filter(p -> p.getPseudo().equals(commande[1])).findAny().orElse(null);
						;
						ecriture.println(personne);
					}

				}
					break;

				case "MODIFIER_PERSONNE": {
					Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
							.filter(p -> p.getPseudo().equals(commande[1])).findAny().orElse(null);
					;
					ecriture.println(personne);
					personne.set(commande[2], commande[3]);
					ecriture.println(personne);

				}
					break;

				case "LOGEMENT": {
					Personne personne = Gestionnaire.ToutesLesPersonnes.stream()
							.filter(p -> p.getPseudo().equals(commande[1])).findAny().orElse(null);
					;
					ecriture.println(personne);
					personne.set(commande[2], commande[3]);
					ecriture.println(personne);

				}
					break;

				default:
					break;
				}

				if (commande[0].equals("FIN")) {
					ecriture.println("Vous vous etes déconnecté");
					getClient().close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
