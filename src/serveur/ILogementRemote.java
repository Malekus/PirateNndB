import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface ILogementRemote extends Remote{

	public int addition(int x, int y) throws RemoteException;
}
