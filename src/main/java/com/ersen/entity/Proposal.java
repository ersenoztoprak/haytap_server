package com.ersen.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ersen.entity.domain.Company;
import com.ersen.entity.domain.Payable;
import com.ersen.entity.enums.ProposalStatus;

@Entity
@Table(name = "proposal")
public class Proposal {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "need_id")
	private Payable need;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Company owner;
	
	@Column
	private BigDecimal price;
	
	@Column
	private String description;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
	private ProposalStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payable getNeed() {
		return need;
	}

	public void setNeed(Payable need) {
		this.need = need;
	}

	public Company getOwner() {
		return owner;
	}

	public void setOwner(Company owner) {
		this.owner = owner;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProposalStatus getStatus() {
		return status;
	}

	public void setStatus(ProposalStatus status) {
		this.status = status;
	}
	
}
