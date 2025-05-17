package com.springejercicios.clinicaestudiantes.repository;

import com.springejercicios.clinicaestudiantes.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InCursoRepository extends JpaRepository <Curso, Long>{
    
    
    
}
