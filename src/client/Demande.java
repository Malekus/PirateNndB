package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Demande implements Runnable {

	Socket socket = null;
	private PrintWriter ecriture;

	public Demande(Socket socket) {
		this.socket = socket;
		try {
			this.ecriture = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String xmlRequete;
		String requete = null;
		boolean stop = false;
		while (!socket.isClosed() && !stop) {
			xmlRequete = "<Requete>\n";
			System.out.println("Menu");
			System.out.println("1 - Personne");
			System.out.println("2 - Logement");
			System.out.println("3 - Emplacement");
			System.out.println("Q - Quitter");
			System.out.print(">> ");
			requete = sc.nextLine();
			switch (requete) {
			case "1": {
				xmlRequete += "\t<Personne>\n";
				System.out.println("Menu - Personne");
				System.out.println("1 - Creer une personne");
				System.out.println("2 - Afficher une personne");
				System.out.println("3 - Afficher toutes les personnes");
				System.out.println("4 - Modifier une personne");
				System.out.println("m - Retourner Menu");
				requete = sc.nextLine();
				switch (requete) {
				case "1": {
					System.out.println("Pseudo de la personne");
					String pseudo = sc.nextLine();
					xmlRequete += "\t\t<Creer>\n\t\t\t<Pseudo>" + pseudo + "</Pseudo>\n";
					System.out.println("Description de la personne");
					String description = sc.nextLine();
					xmlRequete += "\t\t\t<Description>" + description + "</Description>\n";
					xmlRequete += "\t\t</Creer>\n\t</Personne>\n</Requete>\n";
					ecriture.println(xmlRequete);
				}
					break;
				case "2": {
					System.out.println("Pseudo de la personne");
					String pseudo = sc.nextLine();
					xmlRequete += "\t\t<Afficher>\n\t\t\t<Pseudo>" + pseudo + "</Pseudo>\n";
					xmlRequete += "\t\t</Afficher>\n\t</Personne>\n</Requete>\n";
					ecriture.println(xmlRequete);
				}
					break;
				case "3": {
					xmlRequete += "\t\t<Afficher>\t\t\n</Afficher>\n\t</Personne>\n</Requete>\n";
					ecriture.println(xmlRequete);
				}
					break;
				case "4": {
					System.out.println("Pseudo de la personne");
					String pseudo = sc.nextLine();
					System.out.println("Attribut de la personne");
					String attribut = sc.nextLine();
					System.out.println("Valeur ?");
					String valeur = sc.nextLine();
					xmlRequete += "\t\t<Modifier>\n\t\t\t<Pseudo>" + pseudo + "</Pseudo>\n";
					xmlRequete += "\t\t\t<Attribut>"+attribut+"</Attribut>\n";
					xmlRequete += "\t\t\t<Valeur>"+valeur+"</Valeur>\n";
					xmlRequete += "\t\t</Modifier>\n\t<Personne>\n</Requete>\n";
					ecriture.println(xmlRequete);
				}
					break;
				default:
					break;
				}
			}
				break;

			case "Q": {
				xmlRequete = "<Requete>\n\t<Quitter>\n\t</Quitter>\n</Requete>\n";
				this.ecriture.println(xmlRequete);
				System.out.println("Vous vous etes déconnecté");
				stop = true;
			}
				break;

			default:
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			/*
			 * if (requete.equals("Q")) {
			 * 
			 * }
			 */

		}

		try {
			socket.close();
		} catch (IOException e) {
			System.out.println(getClass());
			System.out.println(e.getMessage());
		}

	}
}
