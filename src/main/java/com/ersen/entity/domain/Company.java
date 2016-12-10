package com.ersen.entity.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ersen.entity.Proposal;
import com.ersen.entity.User;
import com.ersen.entity.enums.UserType;

@Entity
@DiscriminatorValue(value = "CORP")
public class Company extends User {

	private String companyName;
	
	private String authorizedPerson;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Proposal> proposals = new ArrayList<Proposal>();
	
	public Company() {
		setType(UserType.CORP);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAuthorizedPerson() {
		return authorizedPerson;
	}

	public void setAuthorizedPerson(String authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	
}
