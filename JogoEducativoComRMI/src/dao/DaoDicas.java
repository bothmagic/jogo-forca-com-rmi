package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dicas;

public class DaoDicas {
        
    public List selectAll() {
        DBConexao dBConexao = new DBConexao();
         List listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            Query query = sessao.createQuery("from Dicas");  
            listagem = query.list();            
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
            ex.printStackTrace();
        }
         return listagem;
    }
    
    public Dicas selectDica(int codDica){
         DBConexao dBConexao = new DBConexao();
         Dicas listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
             Query query = sessao.createSQLQuery("select * from jogoeducativo.tb_dicas where dic_codigo = :codigo")
                                        .addEntity(Dicas.class).setInteger("codigo", codDica);
            listagem = (Dicas)query.uniqueResult();           
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
            ex.printStackTrace();
        }
         return listagem;
    }
    
    public List<Dicas> selectDicaComFiltro(String pesq){
         DBConexao dBConexao = new DBConexao();
         List<Dicas> listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
             Query query = sessao.createSQLQuery("select * from jogoeducativo.tb_dicas where upper(dic_descricao) like(upper('%"+pesq+"%'))")
                                                                                .addEntity(Dicas.class);
            listagem = query.list();           
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
            ex.printStackTrace();
        }
         return listagem;
    }
}
