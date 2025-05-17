package com.springejercicios.clinicaestudiantes.controller;

import com.springejercicios.clinicaestudiantes.model.Curso;
import com.springejercicios.clinicaestudiantes.model.Tema;
import com.springejercicios.clinicaestudiantes.service.InCursoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    private InCursoService cursoServ;
    
    //Endpoint para crear un curso
    @PostMapping("/cursos/crear")
    public String createCurso(@RequestBody Curso c){
        cursoServ.saveCurso(c);
        return "El curso " + c.getNombre() + " fue creado con éxito.";
    }
    
    //Endpoint para ver todos los cursos
    @GetMapping("/cursos/traer")
    public List<Curso> getCursos(){
        return cursoServ.getCursos();
    }
    
    //Endpoint para obtener los temas de un curso en particular
    @GetMapping("/cursos/temas/{id}")
    public List<Tema> getTemasDelCurso(@PathVariable Long id){
        return cursoServ.getTemasDelCurso(id);
    }
    
    //Endpoint para ver todos los cursos sobre Java
    @GetMapping("/cursos/java")
    public List<Curso> getCursosJava(){
        return cursoServ.getCursosJava();
    }
    
    //Endpoint para editar un curso
    @PutMapping("/cursos/editar/{id_Original}")
    public Curso editCurso(@PathVariable Long id_Original,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "modalidad") String nuevaModalidad,
            @RequestParam(required = false, name = "fecha") LocalDate nuevaFecha,
            @RequestParam(required = false, name = "temas") List<Tema> nuevosTemas){
        cursoServ.editCurso(id_Original, nuevoNombre, nuevaModalidad, nuevaFecha, nuevosTemas);
        return cursoServ.getCurso(id_Original);
    }
    
}
