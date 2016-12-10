package com.ersen.entity.dto.response;

import com.ersen.entity.domain.Company;

public class CompanyDTO extends UserDTO {
	
	public String companyName;
	public String authorizedPerson;
	
	protected CompanyDTO(Company company) {
		super(company);
		this.companyName = company.getCompanyName();
		this.authorizedPerson = company.getAuthorizedPerson();
	}
}
