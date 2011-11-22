package facades;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import servidor.I_RMI;

public class FacadeRanking {
    private I_RMI servidor = null;    
    public ArrayList dadosParaPassar = new ArrayList(); 
    
    public ArrayList fachadaRanking(){
        this.instanciaConexaoServidor();
        this.recuperaTodosJogadores();
        return this.dadosParaPassar;
    }
    
    private void instanciaConexaoServidor(){        
         try {
            Registry registry = LocateRegistry.getRegistry("localhost");
             servidor = (I_RMI) Naming.lookup("rmi://localhost:1099/JogoEducativo");
             dadosParaPassar.add(servidor);
            } catch (RemoteException e) {
            System.out.println();
            System.out.println("RemoteException: " + e.toString());
        } catch (NotBoundException e) {
            System.out.println();
            System.out.println("NotBoundException: " + e.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private void recuperaTodosJogadores(){
        try {
            dadosParaPassar.add(servidor.retornaRanking());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
