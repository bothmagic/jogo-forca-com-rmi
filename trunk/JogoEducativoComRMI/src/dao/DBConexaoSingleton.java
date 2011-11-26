package dao;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import servidor.I_RMI;
import utils.HibernateUtil;

public class DBConexaoSingleton {
    private static I_RMI servidor;
    
    public Session openConection(){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return sessao;
    }
    
    public I_RMI getServidorSingleton(){
        if(servidor == null){
            instanciaConexaoServidor();
        }
            return servidor;
    }
    
    
    public void instanciaConexaoServidor(){     
         try {
             Registry registry = LocateRegistry.getRegistry("localhost");
             servidor = (I_RMI) Naming.lookup("rmi://localhost:1099/JogoEducativo");
            } catch (RemoteException e) {
                System.out.println("RemoteException: " + e.toString());
            } catch (NotBoundException e) {
                System.out.println("NotBoundException: " + e.toString());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } 
    }
}
