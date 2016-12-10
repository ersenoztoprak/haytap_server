package com.ersen.entity.builder;

import com.ersen.entity.domain.Company;

public class CompanyBuilder extends UserBuilder {

	public CompanyBuilder () {
		user = new Company();
	}
	
}
