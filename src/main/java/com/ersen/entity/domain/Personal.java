package com.ersen.entity.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ersen.entity.Need;
import com.ersen.entity.User;
import com.ersen.entity.enums.UserType;

@Entity
@DiscriminatorValue(value = "INDVL")
public class Personal extends User {

	@Column
	private String name;
	
	@Column
	private String surname;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Need> needs = new ArrayList<Need>();
	
	@OneToMany(mappedBy = "supporter", cascade = CascadeType.ALL)
	private List<Supporter> supporters = new ArrayList<Supporter>();
	
	public Personal() {
		setType(UserType.INDVL);
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

	public List<Need> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Need> needs) {
		this.needs = needs;
	}

	public List<Supporter> getSupporters() {
		return supporters;
	}

	public void setSupporters(List<Supporter> supporters) {
		this.supporters = supporters;
	}
	
}
