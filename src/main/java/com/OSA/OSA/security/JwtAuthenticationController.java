package com.OSA.OSA.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.OSA.OSA.model.entity.Buyer;
import com.OSA.OSA.model.entity.Role;
import com.OSA.OSA.model.entity.SalesMen;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.payload.LoginRequest;
import com.OSA.OSA.payload.MessageResponse;
import com.OSA.OSA.payload.SalesmenSignupRequest;
import com.OSA.OSA.payload.SignupRequest;
import com.OSA.OSA.repository.UserRepo;
import com.OSA.OSA.repository.BuyerRepo;
import com.OSA.OSA.repository.RoleRepository;
import com.OSA.OSA.repository.SalesMenRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/auth")
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtTokenUtil;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private BuyerRepo buyerRepository;
	
	@Autowired
	private SalesMenRepo salesmenRepository;
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		MyUserDetails userDetails =  (MyUserDetails) authentication.getPrincipal();
		
		String jwt = jwtTokenUtil.generateToken(userDetails);
		

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		
		return ResponseEntity.ok(new JWTResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 roles));
}
	

	
	@PostMapping("buyer/signup")
	public ResponseEntity<?> registerBuyer(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		User user = new User(signUpRequest.getUsername(), signUpRequest.getFirstname(), signUpRequest.getLastname(), encoder.encode(signUpRequest.getPassword()), signUpRequest.isBlocked() == true);

		
//		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName("BUYER")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);
		
		Buyer buyer = new Buyer(signUpRequest.getAdress());
		buyer.setUser(user);
		buyerRepository.save(buyer);

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PostMapping("salesmen/signup")
	public ResponseEntity<?> registerSalesmen(@Valid @RequestBody SalesmenSignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		User user = new User(signUpRequest.getUsername(), signUpRequest.getFirstname(), signUpRequest.getLastname(), encoder.encode(signUpRequest.getPassword()), signUpRequest.isBlocked() == true);

		
//		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleRepository.findByName("SALESMEN")
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);
		
		SalesMen salesmen = new SalesMen(signUpRequest.getAdress(), signUpRequest.getBegin_date(), signUpRequest.getName());
		salesmen.setUser(user);
		salesmenRepository.save(salesmen);

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//
//		User user = new User(signUpRequest.getUsername(), signUpRequest.getFirstname(), signUpRequest.getLastname(), encoder.encode(signUpRequest.getPassword()), signUpRequest.isBlocked() == true);
//		
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			
//			System.out.println("NEMA ROLE");
//			
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName("ADMIN")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName("SALESMEN")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName("BUYER")
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}

}
