package com.lhs.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lhs.dao.RegistrationRepo;

@Service
public class ImplementationUserDetailsService implements UserDetailsService {

	@Autowired
	RegistrationRepo registrationRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		RegistrationEntity reg = registrationRepo.findByUsername(username);
//		System.out.println("ll"+reg);
//		if (reg == null) {
//System.out.println("usernot found");
//			throw new GlobalExceptionHandler("707", "error found in user details class 26");
//
//		}
//		return new ImpleUserDetails(reg);
		
		
		
		return new  User("sai","saicharan1656",new ArrayList<>());

	}

}
