package com.baylogic.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baylogic.model.UserLoginData;
import com.baylogic.repositories.UserLoginDataRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserLoginDataRepository userRepository;	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginData userLoginData = userRepository.findByUsername(username);
        if(userLoginData!= null) {
        	 return new User(
        			 userLoginData.getUsername(), 
        			 userLoginData.getPassword(), 
		                true, 
		                true, 
		                true, 
		                true,
		                getAuthorities()
		        );
        }      
        return null;
    }
    
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authList =  new ArrayList<GrantedAuthority>();
		 authList.add(new SimpleGrantedAuthority("doctor"));
		 return authList;
	}
	
}
