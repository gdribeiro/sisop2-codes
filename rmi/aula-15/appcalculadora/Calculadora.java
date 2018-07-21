package appcalculadora;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public interface Calculadora extends Remote {

	public int somarInt(int val1, int val2) throws RemoteException;
 
	public int multiplicaInt(int val1, int val2) throws RemoteException;
}
