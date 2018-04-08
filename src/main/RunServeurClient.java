package main;

public class RunServeurClient {

	public static void main(String[] args) {
		Thread threadServeur = new Thread(new MainServeur());
		Thread threadClient = new Thread(new MainClient());
		threadServeur.setPriority(Thread.MAX_PRIORITY);
		threadClient.setPriority(Thread.MIN_PRIORITY);
		threadServeur.start();
		threadClient.start();
	}

}
