package test;

import serveur.Serveur;

public class MainServeur{
	/*@Override
	public void run() {
		Serveur serveur = new Serveur(1234);
		serveur.lancement();	
	}*/
	
	
	public static void main(String[] args) {
		Serveur serveur = new Serveur(1234);
		serveur.lancement();
	}
}
