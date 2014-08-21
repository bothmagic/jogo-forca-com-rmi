package servidor;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RMI_ServidorSemRegistry {

    public RMI_ServidorSemRegistry() {
        try {
            I_RMI o = new RMI_Impl();               
            
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("JogoEducativo", o);
            System.out.println("O servidor esta ativo!");
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
}