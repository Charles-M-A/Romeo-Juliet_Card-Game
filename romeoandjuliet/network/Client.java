package cst4010.romeoandjuliet.network;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        ServerIntf server = (ServerIntf) Naming.lookup("//localhost/RmiServer");
        server.getGame().main(args = null);
    }
}
