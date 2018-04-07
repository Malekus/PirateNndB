package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket socket;
	private int port;

	public Client(String adresse, int port) {
		this.port = port;
		try {
			this.socket = new Socket(adresse, port);
			Thread thDemande = new Thread(new Demande(this.socket));
			Thread thEcoute = new Thread(new Ecoute(this.socket));
			thDemande.setPriority(Thread.MAX_PRIORITY);
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
}
