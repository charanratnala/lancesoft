package com.lhs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhs.dao.RegistrationRepo;
import com.lhs.entity.RegistrationEntity;

@Service
public class GetService {

	@Autowired
	RegistrationRepo registrationRepo;

	public Iterable<RegistrationEntity> getUsers() {
		try {
		Iterable<RegistrationEntity> entity = registrationRepo.findAll();
		return entity;	}
		
		catch (Exception e) {
			throw new RuntimeException("error in getService");
		}
		
	}

}
