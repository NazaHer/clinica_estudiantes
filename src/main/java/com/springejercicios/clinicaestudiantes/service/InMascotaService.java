package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Mascota;
import com.springejercicios.clinicaestudiantes.model.Persona;
import java.util.List;

public interface InMascotaService {
    
    public void saveMascota(Mascota m);
    
    public Mascota getMascota(Long id);
    
    public void editMascota(Long id, String nombre, String especie, String raza, String color, Persona responsable);
    
    public void deleteMascota(Long id);
    
    public List<Mascota> getCaniches();
    
    public List<Mascota> getMascotas(); 
    
}
