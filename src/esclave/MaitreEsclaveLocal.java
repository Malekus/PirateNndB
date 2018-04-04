package esclave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Serveur;

public class MaitreEsclaveLocal implements Runnable {
	private final Socket client;
	private final Serveur serveur;
	private boolean enCours = true;

	public MaitreEsclaveLocal(Socket client, Serveur serveur) {
		this.client = client;
		this.serveur = serveur;
		// envoie("Vous etes connecté");
	}

	public void run() {
		boolean fin = false;
		System.out.println("Connexion en Local");
		while (!this.getClient().isClosed()) {
			try {
				System.out.println(Thread.currentThread());
				BufferedReader lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
				String commande[] = lecture.readLine().split(" ");
				PrintWriter ecriture = new PrintWriter(client.getOutputStream(), true);
				System.out.println(commande[0]);
				switch (commande[0]) {
				case "fin": {
					fin = true;
				}
					break;

				default:
					break;
				}
				if (fin) {
					ecriture.println("Vous vous etes déconnecté");
					lecture = null;
					ecriture = null;
					client.close();
					break;
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

	public void envoie(String texte) {
		try {
			PrintWriter ecriture = new PrintWriter(getClient().getOutputStream(), true);
			ecriture.println(texte);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
