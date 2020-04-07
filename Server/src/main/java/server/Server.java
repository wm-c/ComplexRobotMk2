package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tasks.Compute;
import tasks.Task;

import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

public class Server extends UnicastRemoteObject implements Compute {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Hello World";

    public Server() throws RemoteException {
        super(0);
    }

    public String getMessage() {
        return MESSAGE;
    }

    public static void main(String args[]) throws Exception {
            System.out.println("RMI server started");
            try { // special exception handler for registry creation
                LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");
            } catch (RemoteException e) {
                // do nothing, error means registry already exists
                System.out.println("java RMI registry already exists.");
            }
        

            // Instantiate RmiServer
            Server server = new Server();

            // Bind this object instance to the name "RmiServer"
            Naming.rebind("//localhost/Server", server);
            System.out.println("PeerServer bound in registry");
            
            System.out.println(System.getProperty("java.security.policy"));
    }

    // @Override
    // public <T> T executeTask(Task<T> t) throws RemoteException {
    //     System.out.println("running");
    //     return t.execute();
        
    // }

    public void stop() throws NoSuchObjectException, RemoteException {
        System.out.println("stopping rmi server.");
        System.exit(0);
    }

    @Override
    public void test() throws RemoteException {
        System.out.println("hello there");

    }

    @Override
    public void test1(String a) throws RemoteException {
        System.out.println(a);

    }

    @Override
    public int test2() throws RemoteException {
        return 36 + 10;
    }

    @Override
    public String test3(String a) throws RemoteException {
        return a;
    }

    @Override
    public int test4(Task t) throws RemoteException {
        return t.execute2();
    }
}
    