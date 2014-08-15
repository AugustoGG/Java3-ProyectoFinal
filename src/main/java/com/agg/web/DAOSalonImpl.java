

package com.agg.web;

import static com.agg.web.DAO.begin;
import static com.agg.web.DAO.close;
import static com.agg.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOSalonImpl extends DAO{
    

    public static ArrayList<Salon> buscarTodos(){
        begin();
        Query q = getSession().createQuery("from salon");
        ArrayList<Salon> salon = (ArrayList<Salon>)q.list();
        commit();
        close();
    return salon;
    }
    
        public static void insertar(Salon s){
        begin();
        getSession().save(s);
        commit();
        close();
    }
    
    public static void actualizar(Salon s){  
         begin();
        getSession().update(s);
        commit();
        close();
    }
    
    public static void borrar(Salon s){
        begin();
        getSession().delete(s);
        commit();
        close();
    }
    
    
    public static Salon buscarId(int id){
        begin();
        Query q = getSession().createQuery("from docente where id_salon = :id");
        q.setInteger("id", id);
        Salon p = (Salon) q.uniqueResult();
        commit();
        close();
        return p;
    }
    
    
    
}
