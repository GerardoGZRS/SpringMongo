/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.service.impl;

import com.opencodez.domain.Users;
import com.opencodez.model.UsersModel;
import java.util.List;

/**
 *
 * @author User
 */
public interface UsersService {
    public abstract UsersModel addUsers(UsersModel contactModel);
	public abstract List<UsersModel>  listAllContact();
	public abstract Users findContactById(String id);
        public abstract UsersModel findContactByIdModel(String id);
        public abstract void removeContact(String id);
        public abstract String select(String id);
        
}
