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
	}

	public void run() {
		while (enCours) {
			try {
				BufferedReader lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
				String commande[] = lecture.readLine().split(" ");
				PrintWriter ecriture = new PrintWriter(client.getOutputStream(), true);

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
