package com.baylogic.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baylogic.model.UserAccount;
import com.baylogic.model.UserLoginData;
import com.baylogic.model.UserRoles;
import com.baylogic.repositories.UserLoginDataRepository;
import com.baylogic.repositories.UserRolesRepository;

@RestController
public class LoginController {
	@Autowired
	private UserRolesRepository rolesRepository;
	@Autowired
	private UserLoginDataRepository usrLgnDtRepo;
	
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

    @PostMapping("register") 
    public void register(@RequestBody UserLoginData userLoginData) {
    	try {		
			String passwordHash = getSHA3_512(userLoginData.getPassword());
			userLoginData.setPasswordHash(passwordHash);
			userLoginData.setHashAlgorithmId((long) 1);
			userLoginData.setEmailValidationStatusId((long) 1);
	    	usrLgnDtRepo.save(userLoginData);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    private String getSHA3_512(String password) throws NoSuchAlgorithmException {
        MessageDigest crypt = MessageDigest.getInstance("SHA3-512");
        crypt.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = crypt.digest();
        BigInteger bi = new BigInteger(1, bytes);
        String passwordHash = String.format("%0" + (bytes.length << 1) + "x", bi);
        return passwordHash;
    }
}
