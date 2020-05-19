/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.service.impl;

import com.opencodez.config.ProfesoresConvert;
import com.opencodez.domain.Profesores;
import com.opencodez.model.ProfesoresModel;
import com.opencodez.repo.ProfesoresRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@EnableMongoRepositories("com.opencodez.repo")
@Service("profesoresServiceImpl")
public class ProfesoresServiceImpl implements ProfesoresService{

    
    @Autowired
    private ProfesoresRepository profesoresRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;
     
    @Autowired
    @Qualifier("profesorConvert")
    private ProfesoresConvert convert;
    
    
    @Override
    public ProfesoresModel addProfesores(ProfesoresModel profesoresModel) {
        Profesores profesores = profesoresRepository.save(convert.convertProfesoresModeltoProfesores(profesoresModel));
        return convert.convertProfesorestoProfesoresModel(profesores);
    }

    
    @Override
    public List<ProfesoresModel> listAllProfesores() {
        List<Profesores> l = profesoresRepository.findAll();
        List<ProfesoresModel> profesoresModels = new ArrayList<ProfesoresModel>();
        for(Profesores p : l){
            profesoresModels.add(convert.convertProfesorestoProfesoresModel(p));
        }
        return  profesoresModels;
    }

    @Override
    public Profesores findProfesoresById(String id) {
        return profesoresRepository.findById(id);
    }

    @Override
    public ProfesoresModel findProfesoresByIdModel(String id) {
        Profesores profesores = profesoresRepository.findById(id);
        return  convert.convertProfesorestoProfesoresModel(profesores);
    }

    
    
    @Override
    public void removeProfesores(String id) {
        Profesores profesores = findProfesoresById(id);
        if(null != profesores){
            profesoresRepository.delete(profesores);
        }
    }

    @Override
    public String select(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
