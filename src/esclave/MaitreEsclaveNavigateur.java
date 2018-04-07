package esclave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import serveur.Serveur;

public class MaitreEsclaveNavigateur implements Runnable {
	private final Socket client;
	private final Serveur serveur;
	private BufferedReader lecture = null;
	private PrintWriter ecriture = null;
	private ArrayList<String> first;
	private boolean enCours = true;

	public MaitreEsclaveNavigateur(Socket client, Serveur serveur, ArrayList<String> first) {
		this.client = client;
		this.serveur = serveur;
		this.first = first;
	}

	@Override
	public void run() {
		System.out.println("Connexion en Navigateur");
		while (!getClient().isClosed()) {
			try {				
				ArrayList<String> commande;
				if(this.first != null) {
					commande = this.first;
					this.first = null;
				}else {
					lecture = new BufferedReader(new InputStreamReader(getClient().getInputStream()));
					String line = lecture.readLine();
					commande = new ArrayList<String>();
					while(!line.isEmpty()) {
						commande.add(line);
						line = lecture.readLine();
					}
				}
				
				for(String e : commande) {
					System.out.println(e);
				}
				ecriture = new PrintWriter(getClient().getOutputStream(), true);
				ecriture.println("HTTP/1.1 200 OK\r\n");
				ecriture.println("<html>Salut toi<html>");
				ecriture.println("\r\n");
				getClient().close();
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
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
