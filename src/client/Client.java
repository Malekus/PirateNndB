package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private Socket socket;

	public Client(int port) {
		try {
			this.socket = new Socket(InetAddress.getLocalHost(), port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void demande(String requete) {
		PrintWriter out;
		try {
			out = new PrintWriter(getSocket().getOutputStream(), true);
			out.println(requete);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ecoute();
	}
	
	public void ecoute() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			System.out.println("Client : "+in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
