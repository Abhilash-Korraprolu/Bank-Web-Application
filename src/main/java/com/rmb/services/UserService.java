package com.rmb.services;

import java.security.Principal;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmb.Constants;
import com.rmb.entities.Permission;
import com.rmb.entities.User;
import com.rmb.repositories.PermissionRepository;
import com.rmb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PermissionRepository permissionRepository;

	public void createUser(User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		user.setPermissions(permissionService.getCustomerPermissions());
		userRepository.save(user);
	}

	public void createAdmin(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Permission> permissions = new ArrayList<>();
		permissions.addAll(permissionService.getCustomerPermissions());
		permissions.add(new Permission(Constants.Permissions.VIEW_ANY_RESOURCE_INFORMATION));
		user.setPermissions(permissions);

		userRepository.save(user);
	}

	public boolean checkIfAlreadyRegisteredPno(String pno) {

		User user = userRepository.findByPno(pno);
		return (user != null) ? true : false;
	}

	public boolean checkIfAlreadyRegisteredEmail(String email) {

		User user = userRepository.findByEmail(email);
		return (user != null) ? true : false;
	}
	
	public List<User> searchUser(String pno, String firstName, String lastName, String city, String email,
			String phoneNumber) {

		List<User> searchResult = new ArrayList<>();

		if ((pno + firstName + lastName + city + email + phoneNumber).equals(""))
			return userRepository.findAll();

		if (!pno.equals(""))
			searchResult.addAll(userRepository.findByPnoLike("%" + pno + "%"));

		if (!firstName.equals(""))
			searchResult.addAll(userRepository.findByFirstNameLike("%" + firstName + "%"));

		if (!lastName.equals(""))
			searchResult.addAll(userRepository.findByLastNameLike("%" + lastName + "%"));

		if (!city.equals(""))
			searchResult.addAll(userRepository.findByCityLike("%" + city + "%"));

		if (!email.equals(""))
			searchResult.addAll(userRepository.findByEmailLike("%" + email + "%"));

		if (!phoneNumber.equals(""))
			searchResult.addAll(userRepository.findByPhoneNumberLike("%" + phoneNumber + "%"));

		return searchResult;

	}

	public List<User> findAll() {

		return userRepository.findAll();
	}

	public List<User> findByPnoLike(String pno) {

		return userRepository.findByPnoLike("%" + pno + "%");
	}
	
	public User findByPnoTemp (String pno) {
		
		return userRepository.findByPno(pno);
	}

	public User findByPno(String pno) {
		
		return userRepository.findByPno(pno);		
	}

	public List<Permission> getUserPermissions() {
		
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		String s = principal.getName();
		User user = userRepository.findByPno(s);
		
		return permissionRepository.findByUsers(user);
	}
}
