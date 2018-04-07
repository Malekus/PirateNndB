package test;

import client.Client;

public class MainClient implements Runnable{
	
	@Override
	public void run() {
		new Client("localhost", 1234);
	}
	
	public static void main(String[] args) {
		Client c = new Client("localhost", 1234);
	}
}
