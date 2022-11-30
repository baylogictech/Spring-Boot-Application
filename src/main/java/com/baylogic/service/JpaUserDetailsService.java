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
import org.springframework.ui.Model;

import com.baylogic.model.UserLoginData;
import com.baylogic.model.UserRoles;
import com.baylogic.repositories.RolesRepository;
import com.baylogic.repositories.UserLoginDataRepository;
import com.baylogic.repositories.UserRolesRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserLoginDataRepository userRepo;	
	@Autowired
	private UserRolesRepository userRolesRepo;
	@Autowired
	private RolesRepository rolesRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginData userLoginData = userRepo.findByUsername(username);
        if(userLoginData!= null) {
        	List<UserRoles> userRoles = userRolesRepo.findByUserId(userLoginData.getUserId());
        	 Collection<? extends GrantedAuthority> authList = getAuthorities(userRoles);
        	 return new User(
        			 userLoginData.getUsername(), 
        			 userLoginData.getPassword(), 
		                true, 
		                true, 
		                true, 
		                true,
		                authList
		        );
        } else {
        	throw new UsernameNotFoundException("Email does not exist");
        }
    }
    
	public Collection<? extends GrantedAuthority> getAuthorities(List<UserRoles> roles) {
		 List<GrantedAuthority> authList =  new ArrayList<GrantedAuthority>();
		 for(UserRoles role: roles) {
			 authList.add(new SimpleGrantedAuthority(rolesRepo.findByRoleId(role.getRoleId()).getRoleDescription()));
		 }
		 return authList;
	}
	
	public UserLoginData getUserLoginData(String username) {
		UserLoginData userLoginData = userRepo.findByUsername(username);
		return userLoginData;
	}
	
}
