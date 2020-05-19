/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.controller;

import com.opencodez.config.ViewConstant;
import com.opencodez.model.UsersModel;
import com.opencodez.service.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/users")
public class UsersController {
   
    @Autowired
	@Qualifier("usersServiceImpl")
	private UsersService usersService;
    /**
     * 
     * @return modelAndView 
     */
    @GetMapping("/showUsers")
	public ModelAndView showProfesores() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.USERS);
                modelAndView.addObject("usersModel", usersService.listAllContact());
                

		return modelAndView;
	}
        
        /**
         * 
         * @param id
         * @param model
         * @return 
         */
        @GetMapping("/usersform")
	public String showForm(@RequestParam(name = "id", required=false) String id, Model model) {
            UsersModel usersModel = new UsersModel();
                try{
                   if (id != null) {
usersModel =	usersService.findContactByIdModel(id);
                       System.err.println("Controller IUsers" + usersModel.toString());    
		} 
                }catch(Exception e){
                    System.out.println("com.jery.contacto.controller.ContactController.redirectContactForm()" +e);
                }
                
                
                
                
                model.addAttribute("usersModel", usersModel);

		return ViewConstant.FORM;
	}
        
        /**
         * 
         * @param model
         * @param m
         * @return 
         */
        @PostMapping("/addUser")
	public String addContact(@ModelAttribute(name = "usersModel") UsersModel model, Model m) {
                System.out.println("Recibo" + model.toString());
		if (null != usersService.addUsers(model)) {
			m.addAttribute("result", 1);
                        
		} else {
			m.addAttribute("result", 0);
		}

		return "redirect:/users/showUsers";
	}
        
        @GetMapping("/removedUsers")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) String id) {
		usersService.removeContact(id);
		return showProfesores();
	}
}
