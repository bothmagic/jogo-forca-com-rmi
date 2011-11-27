package facades;

import dao.DBConexaoSingleton;
import java.text.ParseException;
import java.util.ArrayList;
import servidor.I_RMI;
import utils.AddDinamicoDe10TextFields;
import utils.AddDinamicoDe3TextFields;
import utils.AddDinamicoDe4TextFields;
import utils.AddDinamicoDe5TextFields;
import utils.AddDinamicoDe6TextFields;
import utils.AddDinamicoDe7TextFields;
import utils.AddDinamicoDe8TextFields;
import utils.AddDinamicoDe9TextFields;

public class FacadeUsuario {
    private I_RMI servidor = null;    
    public ArrayList dadosParaPassar = new ArrayList(); 
    
    public ArrayList fachadaLogin() throws ParseException{
        this.getInstanciaServidor();
        this.instanciaTdsOsAddDinamicos();
        return this.dadosParaPassar;
    }
    
    private void getInstanciaServidor(){        
         servidor = new DBConexaoSingleton().getServidorSingleton();
         dadosParaPassar.add(servidor);           
    }
    
    private void instanciaTdsOsAddDinamicos() throws ParseException{
        dadosParaPassar.add(new AddDinamicoDe3TextFields());
        dadosParaPassar.add(new AddDinamicoDe4TextFields());
        dadosParaPassar.add(new AddDinamicoDe5TextFields());
        dadosParaPassar.add(new AddDinamicoDe6TextFields());
        dadosParaPassar.add(new AddDinamicoDe7TextFields());
        dadosParaPassar.add(new AddDinamicoDe8TextFields());
        dadosParaPassar.add(new AddDinamicoDe9TextFields());
        dadosParaPassar.add(new AddDinamicoDe10TextFields());
    }
}
