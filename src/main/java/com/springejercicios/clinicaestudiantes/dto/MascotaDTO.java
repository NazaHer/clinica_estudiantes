package com.springejercicios.clinicaestudiantes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDTO {
    
    private String nombre;
    private String especie;
    private String raza;
    private String nombre_Dueno;
    private String apellido_Dueno;
    
    public MascotaDTO(){
    }

    public MascotaDTO(String nombre, String especie, String raza, String nombre_Dueno, String apellido_Dueno) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.nombre_Dueno = nombre_Dueno;
        this.apellido_Dueno = apellido_Dueno;
    }
    
}
