/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.config;

import com.opencodez.domain.Profesores;
import com.opencodez.model.ProfesoresModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("profesorConvert")
public class ProfesoresConvert {
    public Profesores convertProfesoresModeltoProfesores(ProfesoresModel profesoresModel){
        Profesores profesores = new Profesores();
       profesores.setId(profesoresModel.getId());
        profesores.setNombre(profesoresModel.getNombre());
        profesores.setApellidoPaterno(profesoresModel.getApellidoPaterno());
        profesores.setApellidoMaterno(profesoresModel.getApellidoMaterno());
        profesores.setCorreo(profesoresModel.getCorreo());
        profesores.setAsignatura(profesoresModel.getAsignatura());
        profesores.setHora(profesoresModel.getHora());
        return  profesores;
    }
    
    public ProfesoresModel convertProfesorestoProfesoresModel(Profesores profesores){
        ProfesoresModel profesoresModel = new ProfesoresModel();
        profesoresModel.setId(profesores.getId());
        profesoresModel.setNombre(profesores.getNombre());
        profesoresModel.setApellidoPaterno(profesores.getApellidoPaterno());
        profesoresModel.setApellidoMaterno(profesores.getApellidoMaterno());
        profesoresModel.setCorreo(profesores.getCorreo());
        profesoresModel.setAsignatura(profesores.getAsignatura());
        profesoresModel.setHora(profesores.getHora());
        return  profesoresModel;
    }
}
