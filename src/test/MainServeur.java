package test;

import serveur.Serveur;

public class MainServeur implements Runnable{
	@Override
	public void run() {
		Serveur serveur = new Serveur(1234);
		serveur.lancement();		
	}
}
