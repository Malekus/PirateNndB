package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import esclave.MaitreEsclaveLocal;
import esclave.MaitreEsclaveNavigateur;
import modele.Gestionnaire;

public class Serveur {
	private ServerSocket serveur;
	private Socket socket;
	private boolean allume = true;
	private final ExecutorService pool;
	private final static int nbPool = 100;

	public Serveur(int port) {
		try {
			this.serveur = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.pool = Executors.newFixedThreadPool(nbPool);
	}

	public void lancement() {
		Gestionnaire.initialisation();
		System.out.println("Serveur lanc�");

		/*
		 * try { LocateRegistry.createRegistry(1099); ServeurImpl od = new
		 * ServeurImpl(); System.out.println(od.toString());
		 * Naming.rebind("rmi://localhost:1099/ADD", od); } catch (Exception e) {
		 * System.out.println(e); }
		 */

		while (allume) {
			try {
				this.setSocket(this.getServeur().accept());
				System.out.println("Une personne s'est connect�");
				pool.execute(new MaitreEsclaveLocal(getSocket(), this));

			} catch (IOException e) {
				System.out.println(getClass());
				System.out.println(e.getMessage());

			}
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
}
