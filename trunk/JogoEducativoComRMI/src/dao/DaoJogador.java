package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pojos.Jogador;

public class DaoJogador {
        
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

    public List selectOrdenado() {
         DBConexao dBConexao = new DBConexao();
         List listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            Criteria pesqCriteria = sessao.createCriteria(Jogador.class)
		  .addOrder(Order.desc("pontuacao"))
                   .addOrder(Order.desc("qtdeFases"));
            listagem = pesqCriteria.list();
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
            ex.printStackTrace();
        }
         return listagem;
    }    
    
     public List selectJogador(String nomePesq){
         DBConexao dBConexao = new DBConexao();
         List listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            Criteria pesqCriteria = sessao.createCriteria(Jogador.class)
		  .add(Restrictions.ilike("nome", "%"+nomePesq+"%"));
            listagem = pesqCriteria.list();
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
              listagem = null;
            ex.printStackTrace();
        }
         return listagem;
   }
    
}
