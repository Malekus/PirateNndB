package esclave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Serveur;

public class MaitreEsclaveNavigateur implements Runnable {
	private final Socket client;
	private final Serveur serveur;
	private boolean enCours = true;

	public MaitreEsclaveNavigateur(Socket client, Serveur serveur) {
		this.client = client;
		this.serveur = serveur;
	}

	@Override
	public void run() {
		System.out.println("Connexion en Navigateur");
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
