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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ServerImpl extends UnicastRemoteObject implements Server {
    
    private final Map<String, Client> clientes = new HashMap<>();
    
    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean addClient(String nomeId, Client client) throws RemoteException {
        System.out.println("Alguém entrou!");
        clientes.put(nomeId, client);
        return true;
    }

    @Override
    public boolean removeClient(String nomeId, Client client) throws RemoteException {
        return clientes.remove(nomeId,client);
    }

    @Override
    public void sendMessageToAll(String msg) throws RemoteException {
        for (Client cliente : clientes.values()) {
            try {
                cliente.alert(msg);
            } catch (RemoteException e) {
                clientes.remove(cliente);
            }
        }
    }

    @Override
    public String receiverMessage(String nomeFrom, String nomeTo) throws RemoteException {
        Client to = clientes.get(nomeTo);
        Client from = clientes.get(nomeFrom);
        if(to == null || from == null)
            return null;
        String msg = to.getMessage();
        return msg;
    }
    
    
}
