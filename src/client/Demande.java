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
			requete = sc.nextLine();
			this.ecriture.println(requete);
			if(requete.equals("FIN")) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
