package client;

import java.io.PrintWriter;
import java.util.Scanner;

public class Demande implements Runnable {

	private PrintWriter ecriture;

	public Demande(PrintWriter out) {
		this.ecriture = out;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String requete = null;
		while (true) {
			requete = sc.nextLine();
			this.ecriture.println(requete);
		}

	}
}
