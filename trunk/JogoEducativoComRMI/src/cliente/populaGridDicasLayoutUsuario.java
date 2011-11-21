package cliente;

import dao.DaoDicas;
import java.sql.SQLException;
import pojos.Dicas;

public class populaGridDicasLayoutUsuario {

   public Dicas popula(int codPesqDica) throws SQLException{
       DaoDicas daoCRUD = new DaoDicas();          
       return daoCRUD.selectDica(codPesqDica);     

  }
}
