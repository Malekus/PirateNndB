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
	private BufferedReader lecture = null;
	private PrintWriter ecriture = null;
	private String first[];
	private boolean enCours = true;

	public MaitreEsclaveNavigateur(Socket client, Serveur serveur, String first[]) {
		this.client = client;
		this.serveur = serveur;
		this.first = first;
	}

	@Override
	public void run() {
		System.out.println("Connexion en Navigateur");
		while (!client.isClosed()) {
			try {
				lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
				ecriture = new PrintWriter(getClient().getOutputStream(), true);
				if(this.first.length != 0) {
					this.first = null;
					ecriture.println("<html>Salut</html>");
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
