
package trabalhoSDRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class RmiServer extends Observable implements RmiService, Serializable {
    
    private class WrappedObserver implements Observer, Serializable {
        private static final long serialVersionUID = 1L;
        private ObserverRemote ro = null;
        public WrappedObserver(ObserverRemote ro) {
            this.ro = ro;
        }

        @Override
        public void update(Observable o, Object arg) {
            try {
                ro.update(o.toString(), arg);
            } catch (RemoteException e) {
                e.printStackTrace();
                o.deleteObserver(this);
            }
        }
    }
    
    @Override
    public void addObserver(ObserverRemote o) throws RemoteException {
        WrappedObserver mo = new WrappedObserver(o);
        addObserver(mo);
    }

    @Override
    public void enviarObjeto(Object obj) {
        setChanged();
        notifyObservers(obj);
    }
}
