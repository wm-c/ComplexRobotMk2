package tasks;

import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    //<T> T executeTask(Task<T> t) throws RemoteException;

    String getMessage() throws RemoteException;
    
    void stop() throws NoSuchObjectException, RemoteException;

    void test() throws RemoteException; 

    void test1(String a) throws RemoteException; 

    int test2() throws RemoteException; 

    String test3(String a) throws RemoteException;

    int test4(Task t) throws RemoteException;
}