/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientside;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverside.Server;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ClientRun {
    public static void main(String a[]) {
        Server h = null;
        try {
            System.setSecurityManager(new RMISecurityManager());
            h = (Server) Naming.lookup("rmi://192.168.0.9:1099/server");
            h.addClient(new ClientImpl());
            h.sendMessageToAll("HUMAN!");
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
    }
}
