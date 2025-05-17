package com.springejercicios.clinicaestudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    private Persona responsable; 
    
    public Mascota(){
    }

    public Mascota(Long id, String nombre, String especie, String raza, String color, Persona responsable) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.responsable = responsable;
    }

    public void actualizarValores(String nombre, String especie, String raza, String color, Persona responsable) {
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
        setColor(color);
        setResponsable(responsable);
    }
    
}
