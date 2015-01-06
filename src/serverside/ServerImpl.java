/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import clientside.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ServerImpl extends UnicastRemoteObject implements Server {
    
    private final List<Client> clientes = new ArrayList<>();
    
    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean addClient(Client client) throws RemoteException {
        System.out.println("Alguém entrou!");
        return clientes.add(client);
        
    }

    @Override
    public boolean removeClient(Client client) throws RemoteException {
        return clientes.remove(client);
    }

    @Override
    public void sendMessageToAll(String msg) throws RemoteException {
        for (Client cliente : clientes) {
            cliente.alert(msg);
        }
    }
    
}
