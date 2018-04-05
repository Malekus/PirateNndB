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

	public Client(String adresse, int port) {
		this.port = port;
		try {
			this.socket = new Socket(adresse, port);
			Thread thDemande = new Thread(new Demande(this.socket));
			Thread thEcoute = new Thread(
					new Ecoute(this.socket));
			thDemande.setPriority(Thread.MAX_PRIORITY);
			thDemande.start();
			thEcoute.start();
			
			// PARTIE RMI
			/*
			ILogementRemote stub =(ILogementRemote)Naming.lookup("rmi://localhost:2018/BK");
			System.out.println(stub.addition(2,4)));*/

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
