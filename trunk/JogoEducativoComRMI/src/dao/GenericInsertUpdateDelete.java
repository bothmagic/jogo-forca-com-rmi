package dao;

import java.lang.reflect.Field;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericInsertUpdateDelete {
    DBConexaoSingleton conexao;
    
    public GenericInsertUpdateDelete(){
        conexao = new DBConexaoSingleton();
    }
                      
     public int insert(Object obj) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        int retorno = -1;
        StringBuilder retornar = new StringBuilder();
        try{
            Session sessao = conexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(obj);
            transacao.commit();
            sessao.close(); 
            
            Class classeObj = obj.getClass();
            System.out.println("nome da classe: "+classeObj.getSimpleName());
            for (Field f : classeObj.getDeclaredFields()) {
                    f.setAccessible(true);
			if (f.getName().equalsIgnoreCase("codigo")){				
                            retornar.append(f.get(obj));
			}
		}
                retorno = Integer.parseInt(retornar.toString());
        }catch(HibernateException ex){
            ex.printStackTrace();
        }        
        return retorno;
    }
    
     public boolean update(Object obj) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        boolean retorno = false;
        int vlr = -1;
        try{
            Session sessao = conexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            sessao.update(obj);
            transacao.commit();
            sessao.close();
            retorno = true;
        }catch(HibernateException ex){
            retorno = false;
            ex.printStackTrace();
        }
        return retorno;
    }
     
      public boolean delete(Object objExcluir){
       DBConexaoSingleton dBConexao = new DBConexaoSingleton();
       boolean retorno = false;
       try{
            Session sessao = dBConexao.openConection();
            Transaction transacao = sessao.beginTransaction();
            sessao.delete(objExcluir);
            transacao.commit();
            sessao.close();
            retorno = true;
       }catch(HibernateException ex){
           retorno = false;
           ex.printStackTrace();
       }
       return retorno;
   }
}