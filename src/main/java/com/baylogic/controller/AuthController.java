package com.baylogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baylogic.model.UserLoginData;
import com.baylogic.service.JpaUserDetailsService;
import com.baylogic.service.TokenService;


@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private JpaUserDetailsService jpaUserDetailsService;
	
    @PostMapping("/loginUser")
    public View token(@RequestBody UserLoginData userLogin, Model model) {
    	try {
	        final UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(userLogin.getUsername());
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
	        UserLoginData userLoginData = jpaUserDetailsService.getUserLoginData(userLogin.getUsername());
	        userLoginData.setUserRoles(userDetails.getAuthorities());
	        String token = tokenService.generateToken(authentication);
	        model.addAttribute("userDetails", userLoginData);
	        model.addAttribute("jwtToken", token);
    	} catch (UsernameNotFoundException e) {
    		model.addAttribute("status", e.getMessage());
    	} catch(AuthenticationException authenticationException) {
    		model.addAttribute("status", authenticationException.getMessage());
    	}
        return new MappingJackson2JsonView();
    }

}
