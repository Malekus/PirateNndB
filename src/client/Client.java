package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private Socket socket;
	private int port;

	public Client(int port) {
		this.port = port;
		try {
			this.socket = new Socket(InetAddress.getLocalHost(), port);
			Thread thDemande = new Thread(new Demande(new PrintWriter(getSocket().getOutputStream(), true)));
			Thread thEcoute = new Thread(
					new Ecoute(new BufferedReader(new InputStreamReader(getSocket().getInputStream()))));
			thDemande.start();
			thEcoute.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void demande(String requete, boolean ecoute) {
		PrintWriter out;
		try {
			out = new PrintWriter(this.getSocket().getOutputStream(), true);
			out.println(requete);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ecoute();
	}

	public void ecoute() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
