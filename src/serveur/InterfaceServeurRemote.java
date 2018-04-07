package serveur; 

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServeurRemote extends Remote {
	
	public int addition(int x, int y) throws RemoteException;
}
