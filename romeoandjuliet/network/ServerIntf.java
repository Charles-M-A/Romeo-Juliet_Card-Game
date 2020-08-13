package cst4010.romeoandjuliet.network;

import cst4010.romeoandjuliet.Main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIntf extends Remote {
    Main getGame() throws RemoteException;
}
