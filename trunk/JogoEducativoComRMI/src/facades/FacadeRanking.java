package facades;

import dao.DBConexaoSingleton;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.I_RMI;

public class FacadeRanking {
    private I_RMI servidor = null;    
    public ArrayList dadosParaPassar = new ArrayList(); 
    
    public ArrayList fachadaRanking(){
        this.getInstanciaServidor();
        this.recuperaTodosJogadores();
        return this.dadosParaPassar;
    }
    
     private void getInstanciaServidor(){        
         servidor = new DBConexaoSingleton().getServidorSingleton();
         dadosParaPassar.add(servidor);           
    }
    
    private void recuperaTodosJogadores(){
        try {
            dadosParaPassar.add(servidor.retornaRanking());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
