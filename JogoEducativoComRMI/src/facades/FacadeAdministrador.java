package facades;

import dao.DBConexaoSingleton;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.I_RMI;

public class FacadeAdministrador {
    private I_RMI servidor = null;    
    public ArrayList dadosParaPassar = new ArrayList(); 
    
    public ArrayList fachadaAdm(){
        this.getInstanciaServidor();
        this.dadosParaListagemDicas();
        return this.dadosParaPassar;
    }
    
    private void getInstanciaServidor(){        
         servidor = new DBConexaoSingleton().getServidorSingleton();
         dadosParaPassar.add(servidor);           
    }
    
    public void dadosParaListagemDicas(){
        try {
            dadosParaPassar.add(servidor.selectDicas());            
            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
