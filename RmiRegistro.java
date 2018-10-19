package trabalhoSDRMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RmiRegistro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // cria registro na porta 1234
            Registry rmiRegistry = LocateRegistry.createRegistry(1234);
            System.out.println("Registro criado.");

            RmiServer srv = new RmiServer();

            RmiService rmiService = (RmiService) UnicastRemoteObject.exportObject(srv, 0);
            rmiRegistry.bind("RmiService", rmiService);

        } catch (AlreadyBoundException | RemoteException e) {
        }
    }

}
