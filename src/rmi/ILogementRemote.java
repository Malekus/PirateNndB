package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface IBanqueRemote extends Remote{

	public double conversion(double mt) throws RemoteException;
}
