/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ClientImpl extends UnicastRemoteObject implements Client {
    
    private String nome;

    public ClientImpl(String nome) throws RemoteException {
       // super();
        this.nome = nome;
    }
    
    @Override
    public void alert(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public String getNome() throws RemoteException {
        return this.nome;
    }
    
    
}
