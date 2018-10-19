package trabalhoSDRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiService extends Remote {
    void addObserver(ObserverRemote o) throws RemoteException;
    void enviarObjeto(Object obj) throws RemoteException;
}
