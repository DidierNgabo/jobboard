package rw.jobportal.dao;


import java.util.List;
import java.util.Objects;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.jobportal.util.DbUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diddy
 */
public class GeneralDao<X> {
    Class<X> type;

    public GeneralDao(Class<X> type) {
        this.type = type;
    }
    
    public String create(X obj){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     ss.save(obj);
     ss.getTransaction().commit();
     ss.close();
     
     return "successfully saved";
     
    }
    
    public String update(X obj){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     ss.update(obj);
     ss.getTransaction().commit();
     ss.close();
     return "successfully updated";
    }
    
    public List<X> findAll(){
       Session ss = DbUtil.getSessionFactory().openSession();
       Transaction tr = ss.beginTransaction();
       List<X> list = ss.createQuery("from "+ type.getName()).list();
       ss.close();
       return list;
    }
    
    public X findById(Integer id){
     Session ss = DbUtil.getSessionFactory().openSession();
     X item = (X) ss.get(type.getName(), id);
     ss.close();
     return item;
    }
    public List<X> findByName(String name){
     Session ss = DbUtil.getSessionFactory().openSession();
     Query query =ss.createQuery("from "+type.getName()+" where title =:name ");
     query.setParameter("name", name);
     List<X> item =  query.list();
     ss.close();
     return item;
    }
    
     public List<X> findByCategory(String name){
     Session ss = DbUtil.getSessionFactory().openSession();
     Query query =ss.createQuery("from "+type.getName()+" where category =:name ");
     query.setParameter("name", name);
     List<X> item =  query.list();
     ss.close();
     return item;
    }
    
    
    
    public String delete(Integer id){
     Session ss = DbUtil.getSessionFactory().openSession();
     ss.beginTransaction();
     X item = (X) ss.get(type.getName(), id);
     ss.delete(item);
     ss.getTransaction().commit();
     ss.close();
    
     return "succesfully deleted";
    }
    
    
    public boolean validate(String email,String pwd){
       Session ss = DbUtil.getSessionFactory().openSession();
     Query query =ss.createQuery("from "+type.getName()+" where email =:email and password =:pwd ");
     query.setParameter("email", email);
     query.setParameter("pwd", pwd);
     X item =  (X) query.uniqueResult();
     ss.close();
     if(Objects.isNull(item)){
       return false;
     }
     return true;
    }
}
