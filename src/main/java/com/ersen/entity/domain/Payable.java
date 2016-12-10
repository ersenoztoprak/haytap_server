package com.ersen.entity.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ersen.entity.Need;
import com.ersen.entity.Proposal;
import com.ersen.entity.Supporter;
import com.ersen.entity.enums.NeedStatus;
import com.ersen.entity.enums.NeedType;

@Entity
@DiscriminatorValue(value = "PAYABLE")
public class Payable extends Need {

	@ManyToOne
	@JoinColumn(name = "builder_id")
	private Company builder;
	
	@Column
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
	private NeedStatus status;
	
	@Column
	private String code;
	
	@OneToMany(mappedBy = "need", cascade = CascadeType.ALL)
	private List<Proposal> proposals = new ArrayList<Proposal>();
	
	@OneToMany(mappedBy = "supportedNeed", cascade = CascadeType.ALL)
	private List<Supporter> supporters = new ArrayList<Supporter>();
	
	public Payable () {
		setType(NeedType.PAYABLE);
	}

	public Company getBuilder() {
		return builder;
	}

	public void setBuilder(Company builder) {
		this.builder = builder;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public NeedStatus getStatus() {
		return status;
	}

	public void setStatus(NeedStatus status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	public List<Supporter> getSupporters() {
		return supporters;
	}

	public void setSupporters(List<Supporter> supporters) {
		this.supporters = supporters;
	}
	
}
