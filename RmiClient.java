package trabalhoSDRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClient extends UnicastRemoteObject implements ObserverRemote {
    
    MessageListener msgListener = null;
    RmiService remoteService = null;
    
    protected RmiClient(MessageListener msgListener) throws RemoteException {
        super();
        this.msgListener = msgListener;
        try {
            this.remoteService = (RmiService) Naming.lookup("//localhost:1234/RmiService");
            this.remoteService.addObserver(this);
        } catch(Exception e) {}
    }

    

    public void sendMessage(Mensagem msg) throws RemoteException {
        this.remoteService.enviarObjeto(msg);
    }
    
    @Override
    public void update(Object observable, Object updateMsg) {
        Mensagem msg = (Mensagem) updateMsg;
        this.msgListener.newMessage(msg);
    }
}
