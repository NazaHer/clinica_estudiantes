package com.springejercicios.clinicaestudiantes.controller;

import com.springejercicios.clinicaestudiantes.model.Tema;
import com.springejercicios.clinicaestudiantes.service.InTemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    
    @Autowired
    private InTemaService temServ;
    
    //Endpoint para crear un tema
    @PostMapping("/temas/crear")
    public String createTema(@RequestBody Tema t){
        temServ.saveTema(t);
        return "El tema " + t.getNombre() + " fue creado con éxito.";
    }
    
    //Endpoint para editar un tema
    @PutMapping("/temas/editar/{id}")
    public Tema editTema(@PathVariable Long id,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "descripcion") String nuevaDescripcion){
        temServ.editTema(id, nuevoNombre, nuevaDescripcion);
        return temServ.getTema(id);
    }
    
}
