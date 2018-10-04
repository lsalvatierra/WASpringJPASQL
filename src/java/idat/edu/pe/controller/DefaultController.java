/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.controller;

import idat.edu.pe.dao.AlumnoDAO;
import idat.edu.pe.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LuisAngel
 */
@Controller
public class DefaultController {
        @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index (Model model){
        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        List<Alumno> lstAlumnos = objAlumnoDAO.ListarAlumnos();
        /*Alumno obj = new Alumno();
        obj.setNomAlumno("Luis");
        lstAlumnos.add(obj);*/
                
        /*List<String> cities= new ArrayList<>();
        cities.add("Paris");
        cities.add("New York");
        cities.add("London");
        cities.add("Delhi");
        cities.add("Beijing");
        model.addAttribute("cities", cities);*/
        model.addAttribute("lstAlumnos",lstAlumnos);
        return "index";
    }
 
    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public String home (){
        return "home";
    }
}
