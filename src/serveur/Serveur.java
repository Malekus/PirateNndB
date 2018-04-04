package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import esclave.MaitreEsclaveLocal;

public class Serveur {
	private ServerSocket serveur;
	private Socket socket;
	private ExecutorService pool;
	private final static int nbPool = 100;

	public Serveur(int port) {
		try {
			this.serveur = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lancement() {
		this.pool = Executors.newFixedThreadPool(nbPool);
		System.out.println("Serveur lancé");
		try {
			this.setSocket(this.getServeur().accept());
			System.out.println("Une personne s'est connecté");
			pool.execute(new MaitreEsclaveLocal(getSocket(), this));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ServerSocket getServeur() {
		return serveur;
	}

	public void setServeur(ServerSocket serveur) {
		this.serveur = serveur;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}
}
