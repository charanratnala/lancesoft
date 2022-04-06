package com.lhs.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.dao.Rolerepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;
import com.lhs.entity.Roles;

@Service
public class RegistrationService implements RegistrationServiceInterface {

	@Autowired
	RegistrationRepo repo;
	@Autowired
	Rolerepo rolerepo;
   

	public RegistrationDto addAccount(RegistrationDto register) {
		RegistrationEntity entity = new RegistrationEntity();
		PasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(register, entity);

		
		
		if (repo.existsByUsername(register.getUsername()))

			throw new GlobalExceptionHandler("501", "already existed username found");

		

		else {
			entity.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));

	

		
		Roles rol = rolerepo.findByRolename(register.getRolen());

		Roles r = new Roles();
		r.setRolename(register.getRolen());
		entity.setRole(new ArrayList<Roles>());
		entity.getRole().add(r);
		repo.save(entity);
		return register;
		}

}
}
