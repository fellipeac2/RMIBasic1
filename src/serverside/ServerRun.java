/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ServerRun {
   
    public static void main(String a[]) {
        try {
            System.setSecurityManager(new RMISecurityManager());
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            ServerImpl obj = new ServerImpl();
            Naming.rebind("server", obj);
            System.out.println("OK!");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
