package com.baylogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baylogic.model.UserLoginData;
import com.baylogic.pojo.User;
import com.baylogic.repositories.UserLoginDataRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserLoginDataRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginData user = userDao.findByEmailAddress(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
				new ArrayList<>());
	}

	public UserLoginData save(UserLoginData user) {/*
											 * UserLoginData newUser = new UserLoginData();
											 * newUser.setEmailAddress(user.getUserName());
											 * newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
											 * newUser.getPasswordSalt("passwordsalt"); newUser.setLoginName("askdjka");
											 */
		return userDao.save(user);
	}
}