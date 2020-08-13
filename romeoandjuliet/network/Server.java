package cst4010.romeoandjuliet.network;

import cst4010.romeoandjuliet.Main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerIntf {
    public static final String MESSAGE = "Hello World";

    public Server() throws RemoteException {
        super(0); // required to avoid the 'rmic' step, see belowte
    }

    public static void main(String[] args) throws Exception {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        //Instantiate RmiServer
        Server server = new Server();

        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//localhost/RmiServer", server);
        System.out.println("PeerServer bound in registry");
    }

    public Main getGame() {
        Main Main = new Main();
        return Main;
    }
}
