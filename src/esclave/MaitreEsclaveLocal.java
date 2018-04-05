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
				for(String e : commande) {
					System.out.println(e);
				}
				
				if(commande[0].equals("FIN")) {
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
