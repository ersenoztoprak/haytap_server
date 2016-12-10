package com.ersen.entity.dto.response;

import com.ersen.entity.User;
import com.ersen.entity.domain.Company;
import com.ersen.entity.domain.Personal;

public class UserDTO {

	public Long id;
	public String username;
	public String email;
	public String phone;
	
	protected UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.phone = user.getPhone();
	}
	
	
	public static UserDTO fromUser(User user) {
		if (user instanceof Personal) {
			return new PersonalDTO((Personal)user);
		}
		else {
			return new CompanyDTO((Company)user);
		}
		
	}
}
