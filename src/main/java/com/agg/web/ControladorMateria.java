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
public class ControladorMateria {
    @RequestMapping (value = "/materia/{nombre_materia}/{id_salon}/{id_mdocente}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String nombre_materia,  
            @PathVariable int id_mdocente, @PathVariable int id_salon){
                try {
            DAOMateriaImpl.insertar(new Materia(nombre_materia, new Docente (id_mdocente), new Salon (id_salon)));
            return "El registro de materia es correcto";
        } catch (Exception e) {
            return "El docente o el salon son erroneos, verificalo!!!";
        }
    }
    @RequestMapping (value = "/materia/{id_materia}/{nombre_materia}/{id_salon}/{id_mdocente}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable String nombre_materia, @PathVariable String hora_inicio, @PathVariable String hora_termino, 
            @PathVariable int id_mdocente, @PathVariable int id_salon){
        try {
            DAOMateriaImpl.insertar(new Materia(nombre_materia, new Docente (id_mdocente), new Salon (id_salon)));
            return "El registro de la Materia se ha actualizado correctamente";
        } catch (Exception e) {
            return "ERROR!!!";
        }
    }    
       
        @RequestMapping (value = "/materia/{id_materia}/{nombre_materia}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_materia, @PathVariable String nombre_materia){
        try {
            DAOMateriaImpl.borrar(new Materia(id_materia, nombre_materia));
            return "El registro se ha eliminado";
        } catch (Exception e) {
            return "ERROR!!!";
        }
    }
   
    @RequestMapping (value = "/materia", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOMateriaImpl.buscarTodos());
    }
    
    @RequestMapping (value = "/materia/{id_materia}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int id){
        return DAOMateriaImpl.buscarId(id).toString();
    }
    }
