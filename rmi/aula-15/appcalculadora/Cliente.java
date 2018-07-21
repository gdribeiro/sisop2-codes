package appcalculadora;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class Cliente {

	public static void main(String args[]) {
            
    
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Calculadora";
            Registry registry = LocateRegistry.getRegistry();
            Calculadora proxy = (Calculadora) registry.lookup(name);
            
            
            
            System.out.println("1+2:" + proxy.somarInt(1,2));
            System.out.println("3*3:" + proxy.multiplicaInt(3,3));
            
            
            
            
            
            
            
        } catch (Exception e) {
            System.err.println("Calculadora exception:");
            e.printStackTrace();
        }	
	}
}
