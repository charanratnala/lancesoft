package com.lhs.restcontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.dto.RegistrationDto;
import com.lhs.entity.RegistrationEntity;
import com.lhs.jwthandler.JwtRequest;
import com.lhs.jwthandler.JwtResponse;
import com.lhs.jwthandler.JwtUtil;
import com.lhs.security.ImplementationUserDetailsService;
import com.lhs.service.GetService;
import com.lhs.service.RegistrationService;

@RestController
//@RequestMapping("/api")
@CrossOrigin("**")
public class RegistrationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	GetService serv;

	Logger logger = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	JwtUtil jwtUtility;

	@Autowired
	ImplementationUserDetailsService detailsService;

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	RegistrationService service;

	@GetMapping("/")
	public String home() {

		logger.info("checking html page ");
		return "Hii Dude";
	}

	@PostMapping("/login")
	public String loginPage() {
		logger.info("login method executed");
		return "login";
	}

	@RequestMapping("/logg")
	public String logout() {
		logger.info("logout called");
		return "logout";
	}

	@PostMapping("/register")
	public ResponseEntity<String> addRegistration(@RequestBody @Valid RegistrationDto register) {

		logger.info("executed add method in controller");
		if (register == null) {
			logger.error("registration object is null");
		}

		service.addAccount(register);
		logger.info("account saved in the database sucessfull");

		return ResponseEntity.ok("added account sucessfully " + register.getUsername());

	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = detailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtUtility.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt));
	}


	@GetMapping("/get")
	public Iterable<RegistrationEntity> get() {

		Iterable<RegistrationEntity> ge = serv.getUsers();
		return ge;

	}

}
