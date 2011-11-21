package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

public class DBConexao {
    
    public Session openConection(){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return sessao;
    }
}
