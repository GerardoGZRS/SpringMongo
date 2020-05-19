/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.service.impl;

import com.opencodez.config.UsersConvert;
import com.opencodez.domain.Users;
import com.opencodez.model.UsersModel;
import com.opencodez.repo.UserRepository;
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
@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService{
  
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("usersComponent")
    private UsersConvert usersConvert;


    @Override
    public UsersModel addUsers(UsersModel contactModel) {
        Users users = userRepository.save(usersConvert.convertUsersModelToUsers(contactModel));
        return usersConvert.convertUserstoUsersModel(users);
    }

    @Override
    public List<UsersModel> listAllContact() {
        List<Users> l = userRepository.findAll();
        List<UsersModel> usersModels = new ArrayList<>();
        for(Users s: l){
            usersModels.add(usersConvert.convertUserstoUsersModel(s));
        }
        return usersModels;
    }

    @Override
    public Users findContactById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UsersModel findContactByIdModel(String id) {
        Users u = userRepository.findById(id);
        return usersConvert.convertUserstoUsersModel(u);
    }

    @Override
    public void removeContact(String id) {
        Users users = findContactById(id);
        if(null != users){
            userRepository.delete(users);
        }
    }

    @Override
    public String select(String id) {
        Users users = new Users();
         try{
          users   = findContactById(id);
        }catch(Exception e){
            System.err.println("No he recibido el parametro");
        }
          
          return  users.toString();
    }
    
    


}
