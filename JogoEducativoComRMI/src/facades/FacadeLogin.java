package facades;

import dao.DBConexaoSingleton;
import java.util.ArrayList;
import servidor.I_RMI;

public class FacadeLogin {
    private I_RMI servidor = null;    
    public ArrayList dadosParaPassar = new ArrayList(); 
    
    public ArrayList fachadaLogin(){
        this.getInstanciaServidor();
        return this.dadosParaPassar;
    }
    
    private void getInstanciaServidor(){        
         servidor = new DBConexaoSingleton().getServidorSingleton();
         dadosParaPassar.add(servidor);           
    }
   
}
