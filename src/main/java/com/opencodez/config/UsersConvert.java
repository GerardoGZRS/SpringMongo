/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.config;

import com.opencodez.domain.Users;
import com.opencodez.model.UsersModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("usersComponent")
public class UsersConvert {
    	public Users convertUsersModelToUsers(UsersModel usersModel) {
		Users users = new Users();
		users.setId(usersModel.getId());
                users.setName(usersModel.getName());
                users.setAddress(usersModel.getAddress());
                users.setSalary(usersModel.getSalary());
		return users;
	}
        
        public UsersModel convertUserstoUsersModel(Users users){
            UsersModel usersModel = new UsersModel();
            usersModel.setId(users.getId());
            usersModel.setName(users.getName());
            usersModel.setAddress(users.getAddress());
            usersModel.setSalary(users.getSalary());
            return usersModel;
        }
}
