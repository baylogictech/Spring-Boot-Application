package com.baylogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baylogic.pojos.Accounts;
import com.baylogic.pojos.Roles;
import com.baylogic.repositories.RolesRepository;

@RestController
public class LoginController {
	@Autowired
	private RolesRepository rolesRepository;
	
	@PostMapping({"/user/login","/*/user/login"})
	public String login(@RequestBody Accounts user) {
		return "Hellow World!!" ;
	}
	       
    @GetMapping("/roles")
    public List<Roles> listAll(Model model) {
        List<Roles> roles = rolesRepository.findAll();
        model.addAttribute("roles", roles); 
        return roles;
    }

}
