import java.rmi.RemoteException;

public class LogementImpl extends UnicastRemoteObject implements ILogementRemote{
	@Override
	public int addition(int x,int y) throws RemoteException {
		return x+y;
	}
}