package complexrobot;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface clientInterface extends Remote{

    String sayHello() throws RemoteException;


}