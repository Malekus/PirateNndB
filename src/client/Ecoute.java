package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Ecoute implements Runnable {

	Socket socket;
	BufferedReader lecture = null;

	public Ecoute(Socket socket) {
		this.socket = socket;
		try {
			lecture = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (!socket.isClosed()) {
			try {
				System.out.println("Vous avez recu : " + this.lecture.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
