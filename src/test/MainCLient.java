package test;

import client.Client;

public class MainCLient implements Runnable{
	public void run() {
		Client client = new Client(1234);
	};
}
