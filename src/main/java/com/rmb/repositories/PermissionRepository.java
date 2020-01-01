package com.rmb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmb.entities.Permission;
import com.rmb.entities.User;

public interface PermissionRepository extends JpaRepository<Permission, String> {

	List<Permission> findByUsers(User user);

	
}
