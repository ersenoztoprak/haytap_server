package com.ersen.entity.builder;

import com.ersen.entity.domain.Personal;

public class PersonalBuilder extends UserBuilder {

	public PersonalBuilder () {
		user = new Personal();
	}
}
