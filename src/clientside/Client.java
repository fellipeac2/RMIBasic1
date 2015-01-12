/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

/**
 *
 * @author FELLIPE ADORNO
 */
public interface Client extends java.rmi.Remote {
    public void alert(String msg) throws java.rmi.RemoteException;
    public String getNome() throws java.rmi.RemoteException;
    public String getMessage() throws java.rmi.RemoteException;
}
