

package com.agg.web;

import static com.agg.web.DAO.close;
import static com.agg.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOMateriaImpl extends DAO{

    public static ArrayList<Materia> buscarTodos(){
        begin();
        Query q = getSession().createQuery("from materia");
        ArrayList<Materia> materias = (ArrayList<Materia>)q.list();
        commit();
        close();
    return materias;
    }
    
    public static void insertar(Materia m){
        begin();
        getSession().save(m);
        commit();
        close();
    }
    
    public static void actualizar(Materia m){  
         begin();
        getSession().update(m);
        commit();
        close();
    }
    
    public static void borrar(Materia m){
        begin();
        getSession().delete(m);
        commit();
        close();
    }
    
    
    public static Materia buscarId(int id){
        begin();
        Query q = getSession().createQuery("from docente where id_materia = :id");
        q.setInteger("id", id);
        Materia p = (Materia) q.uniqueResult();
        commit();
        close();
        return p;
    }
}
