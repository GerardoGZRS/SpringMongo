/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opencodez.controller;

import com.opencodez.config.ViewConstant;
import com.opencodez.domain.Profesores;
import com.opencodez.model.ProfesoresModel;
import com.opencodez.service.impl.ProfesoresService;
import com.opencodez.service.impl.SequenceGeneratorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 *
 * @author User
 */
@org.springframework.web.bind.annotation.RestController
@Controller
@RequestMapping("profesores")
public class ProfesoresController {
    
    /**
     * 
     */
    
    @Autowired
    @Qualifier("profesoresServiceImpl")
    private ProfesoresService profesoresService;
    
    
    
    @Autowired
    @Qualifier("sequenceGenerator")
    SequenceGeneratorService generatorService;
    /**
     * 
     * @return 
     */
    @GetMapping("/showProfesores")
	public ModelAndView showProfesores() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.PROFESORES);
                modelAndView.addObject("profesores", profesoresService.listAllProfesores());
                

		return modelAndView;
	}
        
        @GetMapping("/profesoresform")
	public ModelAndView showForm(@RequestParam(name = "id", required=false) String id, Model model) {
            ModelAndView modelAndView = new ModelAndView(ViewConstant.PROFESORES_F);
            ProfesoresModel profModel = new ProfesoresModel();
                //modelAndView.addObject("contacts", contactService.listAllContact());
                try{
                   if (id != null) {
        profModel =	profesoresService.findProfesoresByIdModel(id);
                       System.err.println("Controller IUsers" + profModel.toString());    
		} 
                }catch(Exception e){
                    System.out.println("com.jery.contacto.controller.ContactController.redirectContactForm()" +e);
                }
               
                model.addAttribute("profesorModel", profModel);
                modelAndView.addObject(model);

		return modelAndView;
	}
        
         @PostMapping("/addProfesor")
	public ModelAndView addContact(@ModelAttribute(name = "profesorModel") ProfesoresModel model, Model m) {   
            if(model.getId() == ""){
                model.setId(String.valueOf(generatorService.generateSequence(Profesores.SECUENCE_NAME)));

		if (null != profesoresService.addProfesores(model)) {
			m.addAttribute("result", 1);
                        
		} else {
			m.addAttribute("result", 0);
		}
            } else{
                profesoresService.addProfesores(model);
            }
		return showProfesores();
	}
        
        @GetMapping("/removedProfesores")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) String id) {
		profesoresService.removeProfesores(id);
		return showProfesores();
	}
        
         @GetMapping("/checkrest")
    public ResponseEntity<List<ProfesoresModel>> checkRest(){
        List<ProfesoresModel> l = new ArrayList<ProfesoresModel>();
        l = profesoresService.listAllProfesores();
        
       
        return  new ResponseEntity<List<ProfesoresModel>>(l, HttpStatus.OK);
    }
}
