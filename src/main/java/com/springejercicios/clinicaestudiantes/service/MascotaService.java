package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Mascota;
import com.springejercicios.clinicaestudiantes.model.Persona;
import com.springejercicios.clinicaestudiantes.repository.InMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements InMascotaService{
    
    @Autowired
    private InMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota m) {
        mascoRepo.save(m);
    }

    @Override
    public Mascota getMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Long id, String nombre, String especie, String raza, String color, Persona responsable) {
        Mascota m = getMascota(id);
        m.actualizarValores(nombre, especie, raza, color, responsable);
        mascoRepo.save(m);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id);
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> caniches = new ArrayList<Mascota>();
        for (Mascota m : mascoRepo.findAll()) {
            if(m.getRaza().equalsIgnoreCase("caniche")){
                caniches.add(m);
            }
        }
        return caniches;
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepo.findAll();
    }
    
}
