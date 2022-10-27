package com.baylogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baylogic.model.UserAccount;
import com.baylogic.model.UserRoles;
import com.baylogic.repositories.UserRolesRepository;

@RestController
public class LoginController {
	@Autowired
	private UserRolesRepository rolesRepository;
	
	@PostMapping({"/user/login","/*/user/login"})
	public String login(@RequestBody UserAccount user) {
		return "Hellow World!!" ;
	}
	       
    @GetMapping("/roles")
    public List<UserRoles> listAll(Model model) {
        List<UserRoles> roles = rolesRepository.findAll();
        model.addAttribute("roles", roles); 
        return roles;
    }

}
