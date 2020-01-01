package com.rmb;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rmb.entities.Permission;
import com.rmb.entities.User;
import com.rmb.repositories.PermissionRepository;
import com.rmb.services.UserService;

public class UserPrincipal implements UserDetails {
	
	private User user;
	private List<Permission> permissions;

	public UserPrincipal(User user, List<Permission> permissions) {
		
		this.user= user;
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			
		//return Collections.singleton(new SimpleGrantedAuthority(""));		
		List<GrantedAuthority> authorities = new ArrayList<>();		
        permissions.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getPermission())));
		
        return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getPno();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
