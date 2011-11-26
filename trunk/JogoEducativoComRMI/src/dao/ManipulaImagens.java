package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Animal;

public class ManipulaImagens {
    
   public Animal saveBook(Animal book){
       DBConexaoSingleton conexaoSingleton = new DBConexaoSingleton(); 
       Session session = conexaoSingleton.openConection();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return book;
   }
   
}
