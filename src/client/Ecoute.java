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
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		while (!socket.isClosed()) {
			try {
				System.err.println(this.lecture.readLine());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
