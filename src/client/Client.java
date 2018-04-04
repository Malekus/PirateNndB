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
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void demande(String requete, boolean ecoute) {
		try {
			this.socket = new Socket(InetAddress.getLocalHost(), port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out;
		try {
			out = new PrintWriter(this.getSocket().getOutputStream(), true);
			out.println(requete);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (ecoute) {
			ecoute();
		}
		
		try {
			out = new PrintWriter(this.getSocket().getOutputStream(), true);
			out.println("fin");
		} catch (IOException e) {
			e.getMessage();
		}
		
		
	}

	public void ecoute() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			System.out.println("Client : " + in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
