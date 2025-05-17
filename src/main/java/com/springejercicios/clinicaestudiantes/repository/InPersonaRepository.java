package com.springejercicios.clinicaestudiantes.repository;

import com.springejercicios.clinicaestudiantes.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InPersonaRepository extends JpaRepository <Persona, Long> {
    
    
    
}
