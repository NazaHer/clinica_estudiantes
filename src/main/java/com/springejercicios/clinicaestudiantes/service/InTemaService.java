package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Tema;

public interface InTemaService {
    
    //Método para crear un tema
    public void saveTema(Tema t);
    
    //Método para editar un tema
    public void editTema(Long id, String nombre, String descripcion);
    
    //Método para obtener un tema
    public Tema getTema(Long id);
    
}
