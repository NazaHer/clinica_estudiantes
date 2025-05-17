package com.springejercicios.clinicaestudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_Tema;
    private String nombre;
    private String descripcion;
    
    public Tema(){
    }

    public Tema(Long id_Tema, String nombre, String descripcion) {
        this.id_Tema = id_Tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void actualizarValores(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    
    
    
}
