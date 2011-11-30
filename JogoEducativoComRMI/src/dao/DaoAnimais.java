package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojos.Animal;

public class DaoAnimais {
    
   public Animal selectUmAnimal(String nomeAnimal){
         DBConexaoSingleton dBConexao = new DBConexaoSingleton();
         Animal listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            Criteria pesqCriteria = sessao.createCriteria(Animal.class)
		  .add(Restrictions.ilike("nome", "%"+nomeAnimal+"%"));
            listagem = (Animal) pesqCriteria.uniqueResult();
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
              listagem = null;
            ex.printStackTrace();
        }
         return listagem;
   }

    public Animal selectRandomAnimal(ArrayList<Animal> animaisJaJogados) {
//        SELECT *  FROM tb_animal ORDER BY DBMS_UTILITY.GET_HASH_VALUE(TO_CHAR(dbms_utility.get_time)||ani_nome,2,1048576);
//Select * From (Select * From emp Order By Dbms_Random.Value) a Where Rownum < 3
                                
                                //duas formas diferentes de se pesquisar registros aleatorios usando oracle
        
        DBConexaoSingleton dBConexao = new DBConexaoSingleton();
         List listagem = null;
         try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
//            SQLQuery pesqRandom = sessao.createSQLQuery("SELECT * FROM tb_animal ORDER BY DBMS_UTILITY.GET_HASH_VALUE"
//                    + "(TO_CHAR(dbms_utility.get_time)||ani_nome,2,1048576)").addEntity(Animal.class);            
            SQLQuery pesqRandom = sessao.createSQLQuery("SELECT * FROM(SELECT * FROM tb_animal ORDER BY Dbms_Random.Value) a"
                    + " where Rownum < 3").addEntity(Animal.class);            
            listagem = pesqRandom.list();
            transacao.commit();
            sessao.close();
          }catch(HibernateException ex){
              listagem = null;
            ex.printStackTrace();
        }    
         Animal aniReturn = null;
         try{          
             if(!animaisJaJogados.isEmpty()){
                if(listagem.size() != animaisJaJogados.size()){                     
                     for (int i = 0; i < animaisJaJogados.size(); i++) {
                         aniReturn = (Animal)listagem.get(i);
                         if(aniReturn.getCodigo() == animaisJaJogados.get(i).getCodigo()){
                             selectRandomAnimal(animaisJaJogados);
                         }else{
                             break;
                         }
                     }                     
                }else{
                    aniReturn = null;
                }
             }else{
                 aniReturn = (Animal) listagem.get(0);
             }
         }catch(IndexOutOfBoundsException ex){
            aniReturn = null;
         }
         return aniReturn;
    }
   
}
