package com.ersen.entity.builder;

import com.ersen.entity.User;

public abstract class UserBuilder {

	protected User user;

	protected UserBuilder() {
		
	}
	
	public UserBuilder id(long id) {
		user.setId(id);
		return this;
	}

	public User get() {
		return user;
	}
}
