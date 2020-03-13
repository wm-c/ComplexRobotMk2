package complexrobot;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class rmiServer implements clientInterface{

    public rmiServer(){}

    @Override
    public String sayHello() throws RemoteException {
        return "HELLO WORLD";
    }

    public static void main(String args[]) {
        
        try {
            rmiServer obj = new rmiServer();
            clientInterface stub = (clientInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }



    
}