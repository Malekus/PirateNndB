package test;

import client.Client;

public class MainCLient implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Client c = new Client(1234);
		//c.demande("toto", true);
	}
}
