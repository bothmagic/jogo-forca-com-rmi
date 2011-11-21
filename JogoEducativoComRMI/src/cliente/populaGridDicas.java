package cliente;

import dao.DaoDicas;
import java.sql.SQLException;
import java.util.List;

public class populaGridDicas {

   public List popula() throws SQLException{
       DaoDicas daoCRUD = new DaoDicas();          
       List retornoListagem = daoCRUD.selectAll();    
        return retornoListagem;
  }
}
