package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Curso;
import com.springejercicios.clinicaestudiantes.model.Tema;
import java.time.LocalDate;
import java.util.List;

public interface InCursoService {
    
    //Método para crear curso
    public void saveCurso(Curso c);
    
    //Método para obtener todos los cursos
    public List<Curso> getCursos();
    
    //Método para obtener todos los temas de un curso
    public List<Tema> getTemasDelCurso(Long id);
    
    //Método para obtener todos los cursos relacionados a Java
    public List<Curso> getCursosJava();
    
    public void editCurso(Long id_Original, String nuevoNombre, String nuevaModalidad, LocalDate nuevaFecha, List<Tema> nuevosTemas);
    
    public Curso getCurso(Long id);
    
}
