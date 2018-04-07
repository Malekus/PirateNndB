package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServeurImpl extends UnicastRemoteObject implements InterfaceServeurRemote{

	protected ServeurImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addition(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x+y;
	}

}
