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
		String requete = null;
		while (!socket.isClosed()) {
			System.out.println("Menu");
			System.out.println("1 - Personne");
			System.out.println("2 - Logement");
			System.out.println("3 - Emplacement");
			System.out.print(">> ");
			requete = sc.nextLine();
			switch (requete) {
			case "1":
				System.out.println("Menu - Personne");
				System.out.println("1 - Personne");
				System.out.println("2 - Logement");
				System.out.println("3 - Emplacement");
				System.out.println("m - Menu");
				requete = sc.nextLine();
				if(requete.equals("m") || requete.equals("M")) {
					continue;
				}
				break;
			case "2":

				break;
			case "3":

				break;

			default:
				break;
			}
			this.ecriture.println(requete);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (requete.equals("FIN")) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
