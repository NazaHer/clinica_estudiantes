package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Persona;
import com.springejercicios.clinicaestudiantes.repository.InPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements InPersonaService {
    
    @Autowired
    private InPersonaRepository persoRepo;

    @Override
    public Persona getPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
}
