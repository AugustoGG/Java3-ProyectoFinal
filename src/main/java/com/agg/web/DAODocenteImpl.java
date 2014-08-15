
package com.agg.web;

import static com.agg.web.DAO.close;
import static com.agg.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAODocenteImpl extends DAO{

    public static ArrayList<Docente> buscarTodos(){
        begin();
        Query q = getSession().createQuery("from docente");
        ArrayList<Docente> docentes = (ArrayList<Docente>)q.list();
        commit();
        close();
    return docentes;
    }
    
    public static void insertar(Docente d){
        begin();
        getSession().save(d);
        commit();
        close();
    }
    
    public static void actualizar(Docente d){  
         begin();
        getSession().update(d);
        commit();
        close();
    }
    
    public static void borrar(Docente d){
        begin();
        getSession().delete(d);
        commit();
        close();
    }
    
    
    public static Docente buscarId(int id){
        begin();
        Query q = getSession().createQuery("from docente where id_mdocente = :id");
        q.setInteger("id", id);
        Docente p = (Docente) q.uniqueResult();
        commit();
        close();
        return p;
    }
}
