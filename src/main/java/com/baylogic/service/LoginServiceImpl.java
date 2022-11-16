package com.baylogic.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baylogic.enums.Status;
import com.baylogic.model.EmailDetails;
import com.baylogic.model.Roles;
import com.baylogic.model.UserLoginData;
import com.baylogic.model.UserRoles;
import com.baylogic.repositories.RolesRepository;
import com.baylogic.repositories.UserLoginDataRepository;
import com.baylogic.repositories.UserRolesRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserLoginDataRepository userLoginDataRepo;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Autowired
    PasswordEncoder passwordEncoder;
	@Autowired
	private EmailService emailService;

	@Override
	@Transactional
	public boolean register(UserLoginData userLoginData) {
		boolean flag = false;
		try { 
			userLoginData.setPassword(passwordEncoder.encode(userLoginData.getPassword()));
			userLoginDataRepo.save(userLoginData);
			Roles role = rolesRepository.findByRoleDescription(userLoginData.getRole());
			UserRoles userRole = new UserRoles();
			userRole.setUserId(userLoginData.getUserId());
			userRole.setRoleId(role.getRoleId());
			userRolesRepository.save(userRole);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	@Transactional
	public boolean resetPassword(String emailId) {
		boolean flag = false;
		UserLoginData user = userLoginDataRepo.findByUsername(emailId);
	    if (user == null) {
	        throw new UsernameNotFoundException("Username not found");
	    }
	    try {
		    Date tokenDate = new Date(); 
	        Timestamp tokenGenerationTime = new Timestamp(tokenDate.getTime());  
	        Timestamp recoveryTokenTime = tokenGenerationTime;
	        final Long duration = (long) (((60 * 60) + 59) * 1000);
	        recoveryTokenTime.setTime(recoveryTokenTime.getTime() + duration);
		    String token = UUID.randomUUID().toString();
		    user.setPasswordRecoveryToken(token);
		    user.setTokenGenerationTime(tokenGenerationTime);
		    user.setEmailValidationStatusId((long) 1);	    
		    user.setRecoveryTokenTime(recoveryTokenTime);
		    userLoginDataRepo.save(user);
		    EmailDetails emailDetails = new EmailDetails();
		    emailDetails.setRecipient(emailId);
		    String subject = "Here's the verification code to reset your password";
	        
	        String content = "Hello,  \n"
	                + "You have requested to reset your password. \n"
	                + "Verification code to change your password: "+token+" \n"
	                + "Ignore this email if you do remember your password, \n"
	                + "or you have not made the request. \n \n"
	                + "Thanks & Regards, \n"
	                + "";
		    emailDetails.setSubject(subject);
		    emailDetails.setMsgBody(content);
		    String status = emailService.sendSimpleMail(emailDetails);
		    flag = true;
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return flag;   
	}
	@Override
	public String validatePasswordResetToken(String token) {
		UserLoginData passToken = userLoginDataRepo.findByPasswordRecoveryToken(token);
		final Calendar cal = Calendar.getInstance();
		if(passToken == null) {
			return "invalidToken";
		} else if (passToken.getRecoveryTokenTime().before(cal.getTime())){
		    return "expiredToken";
		} else {
			return "validToken";
		}
	}
	@Override
	public boolean changePassword(UserLoginData userData) {
		UserLoginData user = userLoginDataRepo.findByUsername(userData.getUsername());
		user.setPassword(passwordEncoder.encode(userData.getPassword()));
		boolean flag = false;
		userLoginDataRepo.save(user);
		flag = true;
		return flag;
	}
}
