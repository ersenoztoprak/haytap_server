package com.ersen.entity.builder;

import com.ersen.entity.Need;

public abstract class NeedBuilder {

	protected Need need;

	protected NeedBuilder() {
		
	}
	
	public NeedBuilder id(long id) {
		need.setId(id);
		return this;
	}

	public Need get() {
		return need;
	}
}
