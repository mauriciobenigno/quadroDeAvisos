package trabalhoSDRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObserverRemote extends Remote {
    void update(Object observable, Object updateMsg) throws RemoteException; 
}
