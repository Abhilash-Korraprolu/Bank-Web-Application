package com.rmb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission {

	@Id
	@Column(length = 100)
	private String permission;

	@ManyToMany(mappedBy = "permissions")
	private List<User> users;
	
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission otherMember = (Permission) object;
        return otherMember.getPermission().equals(getPermission());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
		return result;
	}
	
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
