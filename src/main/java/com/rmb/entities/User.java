package com.rmb.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.rmb.Constants;

@Entity
//@NamedEntityGraph(name = "graph.User.permissions", 
//attributeNodes = @NamedAttributeNode("permissions"))
public class User {

	@Id
	@Size(min = 12, max = 12)
	private String pno;
	@Size(min = 5)
	private String password;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private String address;
	@NotBlank
	private String city;
	@Email
	@NotBlank
	@Column(unique = true)
	@Length(max = 30)
	private String email;
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;
	private LocalDateTime userCreationTimeStamp;
	private LocalDateTime userClosingTimeStamp;
	private String status = Constants.Status.ACTIVE;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Account> accounts;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Permissions", joinColumns = {
			@JoinColumn(name = "UserPno", referencedColumnName = "pno") }, inverseJoinColumns = {
					@JoinColumn(name = "UserPermission", referencedColumnName = "permission") })
	private List<Permission> permissions;

	public User(@NotBlank String pno, @Size(min = 5) String password, @NotBlank String firstName,
			@NotBlank String lastName, String address, @NotBlank String city,
			@Email @NotBlank @Length(max = 20) String email, String phoneNumber) {

		this.pno = pno;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User() {
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getUserCreationTimeStamp() {
		return userCreationTimeStamp;
	}

	public void setUserCreationTimeStamp(LocalDateTime userCreationTimeStamp) {
		this.userCreationTimeStamp = userCreationTimeStamp;
	}

	public LocalDateTime getUserClosingTimeStamp() {
		return userClosingTimeStamp;
	}

	public void setUserClosingTimeStamp(LocalDateTime userClosingTimeStamp) {
		this.userClosingTimeStamp = userClosingTimeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
