/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.service.impl;

import com.opencodez.domain.Profesores;
import com.opencodez.model.ProfesoresModel;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProfesoresService {
     public abstract ProfesoresModel addProfesores(ProfesoresModel profesoresModel);
	public abstract List<ProfesoresModel>  listAllProfesores();
	public abstract Profesores findProfesoresById(String id);
        public abstract ProfesoresModel findProfesoresByIdModel(String id);
        public abstract void removeProfesores(String id);
        public abstract String select(String id);
   
}
