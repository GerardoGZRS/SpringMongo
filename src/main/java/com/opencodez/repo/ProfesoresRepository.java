/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.repo;

import com.opencodez.domain.Profesores;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository("profesoresRepository")
public interface ProfesoresRepository extends MongoRepository<Profesores, String>{
     public abstract Profesores findById(String id);
    
  
}
