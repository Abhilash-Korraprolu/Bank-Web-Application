package com.rmb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmb.Constants;
import com.rmb.entities.Permission;

@Service
public class PermissionService {

	public List<Permission> getCustomerPermissions() {

		List<Permission> customerPermissions = new ArrayList<>();
		customerPermissions.add(new Permission(Constants.Permissions.VIEW_OWN_RESOURCE_INFORMATION));
		customerPermissions.add(new Permission(Constants.Permissions.TRANSFER_FROM_OWN_ACCOUNT));
		customerPermissions.add(new Permission(Constants.Permissions.CREATE_OWN_ACCOUNT));

		return customerPermissions;
	}
}
