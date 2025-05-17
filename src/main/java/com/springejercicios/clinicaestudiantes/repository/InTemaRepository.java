package com.springejercicios.clinicaestudiantes.repository;

import com.springejercicios.clinicaestudiantes.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InTemaRepository extends JpaRepository <Tema, Long> {
    
    
    
}
