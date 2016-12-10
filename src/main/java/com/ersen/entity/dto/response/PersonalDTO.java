package com.ersen.entity.dto.response;

import com.ersen.entity.domain.Personal;

public class PersonalDTO extends UserDTO{

	public String name;
	public String surname;
	
	protected PersonalDTO(Personal personal) {
		super(personal);
		this.name = personal.getName();
		this.surname = personal.getSurname();
	}
	
}
