package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import esclave.MaitreEsclaveLocal;
import modele.Gestionnaire;
import rmi.LogementImpl;

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
		System.out.println("Serveur lancé");
		while (allume) {
			try {
				this.setSocket(this.getServeur().accept());
				System.out.println("Une personne s'est connecté");
				/*BufferedReader lecture = new BufferedReader(new InputStreamReader(this.getSocket().getInputStream()));
				String requete[] = lecture.readLine().split(" ");
				System.out.println(lecture.readLine());*/
				/*if (requete[0].equals("GET") && requete[2].equals("HTTP/1.1")) {
					pool.execute(new MaitreEsclaveNavigateur(this.getSocket(), this));
				} else {*/
				pool.execute(new MaitreEsclaveLocal(this.getSocket(), this));
				//}
				
				
				//PARTIE RMI
				/*LocateRegistry.createRegistry(2018);
				LogementImpl od = new LogementImpl();
				System.out.println(od.toString());
				Naming.rebind("rmi://localhost:2018/BK", od);*/
				
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
				;
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
