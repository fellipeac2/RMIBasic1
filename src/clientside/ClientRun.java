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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverside.Server;

/**
 *
 * @author FELLIPE ADORNO
 */
public class ClientRun {
    public static void main(String a[]) {
        Scanner in = new Scanner(System.in);
        Server h = null;
        ClientImpl client = null;
        try {
            System.setSecurityManager(new RMISecurityManager());
            if(LocateRegistry.getRegistry(Registry.REGISTRY_PORT) == null)
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            h = (Server) Naming.lookup("rmi://192.168.0.9:"+Registry.REGISTRY_PORT+"/server");
            System.out.println("Escreva seu nome:");
            client = new ClientImpl(in.nextLine());
            h.addClient(client.getNome(), client);
            h.sendMessageToAll(client.getNome()+"->"+"HERE IS A HUMAN!");
            String txt;
            do {
                txt = in.nextLine();
                if(txt.equals("$"))
                    System.out.println("RECEIVER:"+h.receiverMessage("fellipe", "ketlin"));
                else
                    h.sendMessageToAll(txt);
            } while(!txt.equals("exit"));
            h.removeClient(client.getNome(), client);
            System.exit(0);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                h.removeClient(client.getNome(), client);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientRun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
