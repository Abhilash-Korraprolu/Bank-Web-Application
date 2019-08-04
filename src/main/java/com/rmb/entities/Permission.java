package com.rmb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission {

	@Id
	@Column(length = 100)
	private String permission;

	@ManyToMany(mappedBy = "permissions")
	private List<User> users;

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Permission(String permission) {
		this.permission = permission;
	}

	public Permission() {
	}
}
