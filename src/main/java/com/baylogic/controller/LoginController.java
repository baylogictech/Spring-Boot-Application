package com.baylogic.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baylogic.model.UserLoginData;
import com.baylogic.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register")
	public View register(@RequestBody UserLoginData user, Model model) {		
		boolean flag = loginService.register(user);
		model.addAttribute("status", flag);
		return new MappingJackson2JsonView();
	}
	
	@PostMapping("/resetPassword")
	public View resetPassword(@RequestBody String emailId,  Model model) {
		try {
			boolean flag = loginService.resetPassword(emailId);
			model.addAttribute("status", flag);
		} catch(UsernameNotFoundException exception ) {
			model.addAttribute("status", "Not a valid user");
		}
		 return new MappingJackson2JsonView();
	}
	
	@PostMapping("/validatePasswordResetToken")
	public View validatePasswordResetToken(@RequestBody String passwordRecoveryToken, Model model){
		String status = loginService.validatePasswordResetToken(passwordRecoveryToken);
		model.addAttribute("status", status);
		return new MappingJackson2JsonView();
	}
	
	@PostMapping("/changePassword")
	public View changePassword(@RequestBody UserLoginData userData, Model model) {
	    boolean flag = loginService.changePassword(userData);
	    model.addAttribute("status", flag);
		return new MappingJackson2JsonView();
	}

	private String getSHA3_512(String password, byte[] salt) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        MessageDigest crypt = MessageDigest.getInstance("SHA3-512");
        crypt.update(salt);
        byte[] bytes = crypt.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }
    
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
