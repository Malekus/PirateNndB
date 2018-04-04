package test;

import client.Client;

public class MainCLient implements Runnable{
	public void run() {
		Client c2 = new Client(1234);
		c2.demande("salut vous", false);
	};
	
	public static void main(String[] args) {
		Client c = new Client(1234);
		c.demande("salut vous", false);
	}
}
