package com.springejercicios.clinicaestudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_Curso;
    private String nombre;
    private String modalidad;
    private LocalDate fecha_Finalizacion;
    @OneToMany
    private List<Tema> temas;
    
    public Curso(){
    }

    public Curso(Long id_Curso, String nombre, String modalidad, LocalDate fecha_Finalizacion, List<Tema> temas) {
        this.id_Curso = id_Curso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fecha_Finalizacion = fecha_Finalizacion;
        this.temas = temas;
    }

    public void actualizarValores(String nuevoNombre, String nuevaModalidad, LocalDate nuevaFecha, List<Tema> nuevosTemas) {
        setNombre(nuevoNombre);
        setModalidad(nuevaModalidad);
        setFecha_Finalizacion(nuevaFecha);
        setTemas(nuevosTemas);
    }
    
}
