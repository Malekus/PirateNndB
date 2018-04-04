package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Ecoute implements Runnable {

	BufferedReader lecture = null;

	public Ecoute(BufferedReader in) {
		this.lecture = in;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Vous avez recu : " + this.lecture.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
