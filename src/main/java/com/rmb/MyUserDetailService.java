package com.rmb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rmb.entities.Permission;
import com.rmb.entities.User;
import com.rmb.repositories.PermissionRepository;
import com.rmb.repositories.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByPno(username);
		
		if (user == null)
			throw new UsernameNotFoundException("Incorrect");
		
		List<Permission> permissions = permissionRepository.findByUsers(user);

		return new UserPrincipal(user, permissions);
	}

}
