package servidor;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RMI_ServidorSemRegistry {// essa classe é responsavel por inicar um serviço

    public RMI_ServidorSemRegistry() {
        try {
            I_RMI o = new RMI_Impl();               
            
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("JogoEducativo", o);
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        RMI_ServidorSemRegistry olaMundoServidorSemRegistry = new RMI_ServidorSemRegistry();
    }
    
}
