

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
public class ControladorSalon {
    
    @RequestMapping(value = "/salon/{edificio}/{nivel}/{numero}", method = RequestMethod.GET  , headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String edificio, @PathVariable int nivel, @PathVariable int numero){
        DAOSalonImpl.insertar(new Salon(edificio, nivel, numero));
        return "El nuevo salon fue registrado como disponible";
    }
    
    @RequestMapping(value = "/salon/{id_salon}/{categoria}",method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id, @PathVariable String edificio){
        DAOSalonImpl.actualizar(new Salon(id, edificio));
        return "La categoria se ha actualizado";
    }
    
    @RequestMapping(value = "/salon/{id_salon}/{edificio}/{nive}/{numero}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_salon, @PathVariable String edificio, @PathVariable int nivel, @PathVariable int numero){
        try {
            DAOSalonImpl.borrar(new Salon(id_salon, edificio, nivel, numero));
            return "El edificio ha sido puesto en estado no disponible";
        } catch (Exception e) {
            return "Los datos son incorrectos";
        }
    }
    
    @RequestMapping(value = "/salon", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String buscarTodos() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOSalonImpl.buscarTodos());
    }
    
    @RequestMapping(value = "/salon/{id_salon}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId(@PathVariable int id){
        return DAOSalonImpl.buscarId(id).toString();
    }
 }    
    

