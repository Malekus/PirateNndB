package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LogementImpl extends UnicastRemoteObject implements ILogementRemote {
	protected LogementImpl() throws RemoteException {
		super();
	}

	@Override
	public int addition(int x, int y) throws RemoteException {
		return x + y;
	}
}