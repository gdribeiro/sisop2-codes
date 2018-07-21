package appcalculadora;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class Servidor implements Calculadora {

	public int somarInt(int val1, int val2) throws RemoteException {
		return val1 + val2;
	
	}
 
	public int multiplicaInt(int val1, int val2) throws RemoteException {
		return val1 * val2;
	}	


	public static void main(String args[]) {
		System.out.println("Running main()");
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
		try {
			String name = "Calculadora";
            Calculadora calcSrv = new Servidor();
			Calculadora proxy =
				(Calculadora) UnicastRemoteObject.exportObject(calcSrv, 0);
            		Registry registry = LocateRegistry.getRegistry();
            		registry.rebind(name, proxy);
            		System.out.println("Calculadora bound!");
		} catch (Exception e) {
			    System.err.println("Calculadora exception:");
			    e.printStackTrace();
		}
		

	}


	

}
