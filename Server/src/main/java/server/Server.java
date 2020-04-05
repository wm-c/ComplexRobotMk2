package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tasks.Compute;
import tasks.Task;

public class Server implements Compute {

    public Server(){
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }


    public static void main(String[] args) {
        System.out.println("getting new security manager");

        System.setProperty("java.security.policy", "C:\\Users\\willm\\Desktop\\Coding\\ComplexRobotMk2\\Server\\src\\main\\java\\server\\security.policy");
        if(System.getSecurityManager() == null){
             System.setSecurityManager(new SecurityManager());
        }

        
        System.out.println("entering try except");
        try{
            String name = "Compute";
            Compute computeEngine = new Server();
            System.out.println("made new server");
            Compute stub = (Compute) UnicastRemoteObject.exportObject(computeEngine, 0);
            System.out.println("created stub");
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("created registry");
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        }
        catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }

    }
    

    






}