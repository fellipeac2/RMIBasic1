/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

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

    @Override
    public String getMessage() throws RemoteException {
        System.out.println("Alguém te fez uma pergunta direta: ");
        return JOptionPane.showInputDialog(null, "Escreva uma mensagem: ");
    }
    
    
    
    
}
