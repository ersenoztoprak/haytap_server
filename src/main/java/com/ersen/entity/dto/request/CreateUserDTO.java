package com.ersen.entity.dto.request;

import com.ersen.entity.enums.UserType;
import com.ersen.util.ValidationUtils;

public class CreateUserDTO {

	private String username;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	private UserType type;
	
	private String name;
	
	private String surname;
	
	private String companyName;
	
	private String authorizedPerson;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorizedPerson() {
		return authorizedPerson;
	}

	public void setAuthorizedPerson(String authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}

	public void validate() {
        ValidationUtils.protectFromNull(username, "username");
        ValidationUtils.protectFromNull(password, "password");
        ValidationUtils.protectFromNull(email, "email");

        ValidationUtils.validateEmail(email);
        ValidationUtils.validatePassword(password);
    }
}
