package esclave;

import java.io.PrintWriter;

public class Esclave {
	private String requete[];
	private PrintWriter out;
	
	public Esclave(String r[], PrintWriter out) {
		this.requete = r;
		this.out = out;
	}

	public String[] getRequete() {
		return requete;
	}

	public PrintWriter getOut() {
		return out;
	}
	
	
	
	
}
