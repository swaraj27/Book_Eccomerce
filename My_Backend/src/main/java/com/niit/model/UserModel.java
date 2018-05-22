package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component

public class UserModel 
{
	
	@Id
	@NotEmpty
	
	private String username;
	
	@NotEmpty
	@Length(min=6,message="Password should contain atleast 6 characters")
	private String password;
	private String role;//admin/user
	private boolean enabled;//true/false
	
	@NotEmpty
	@Column(unique=true)
	private String custname;
	
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})")
	private String custmob;
	
	@NotEmpty
	@Email(message="Enter a valid Email")
	private String custmail;
	
	@NotEmpty
	private String custaddress;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustmob() {
		return custmob;
	}
	public void setCustmob(String custmob) {
		this.custmob = custmob;
	}
	public String getCustmail() {
		return custmail;
	}
	public void setCustmail(String custmail) {
		this.custmail = custmail;
	}
	public String getCustaddress() {
		return custaddress;
	}
	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}
	
	
	
}
