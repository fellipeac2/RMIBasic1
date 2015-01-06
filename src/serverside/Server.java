/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

/**
 *
 * @author FELLIPE ADORNO
 */
public interface Server extends java.rmi.Remote {
    public boolean addClient(clientside.Client client) throws java.rmi.RemoteException;
    public boolean removeClient(clientside.Client client) throws java.rmi.RemoteException;
    public void sendMessageToAll(String msg) throws java.rmi.RemoteException;
}
