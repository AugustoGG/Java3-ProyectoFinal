

package com.agg.web;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorDocente {
    
    @RequestMapping(value = "/docente/{nombre_docente}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String nombre_docente){
        DAODocenteImpl.insertar(new Docente(nombre_docente));
        return "El nuevo docente ha sido dado de alta";
    }
    
    
    @RequestMapping(value = "/docente/{id_docente}/{nombre_docente}",method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id_mdocente, @PathVariable String nombre_docente){
        DAODocenteImpl.actualizar(new Docente (id_mdocente, nombre_docente));
        return "El docente esta actualizado";
    }
    
    @RequestMapping(value = "/docente/{id_docente}/{nombre_docente}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_mdocente, @PathVariable String nombre_docente){
        
        try {
            DAODocenteImpl.borrar(new Docente(id_mdocente, nombre_docente));
            return "Los datos del docente estan actualizados";
        } catch (Exception e) {
            return "Verifique los datos del Docente";
        }
    }
    
    @RequestMapping(value = "/docente", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String buscarTodos() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAODocenteImpl.buscarTodos());
    }
    
    @RequestMapping(value = "/docente/{id_mdocente}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarId(@PathVariable int id_mdocente){
        return DAODocenteImpl.buscarId(id_mdocente).toString();
    }
    
}
