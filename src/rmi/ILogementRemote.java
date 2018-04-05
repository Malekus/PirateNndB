package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogementRemote extends Remote {

	public int addition(int x, int y) throws RemoteException;
}
