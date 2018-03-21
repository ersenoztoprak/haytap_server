package com.ersen.entity.domain;

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

import com.ersen.entity.enums.ProposalStatus;

@Entity
@Table(name = "proposal")
public class Proposal {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "need_id")
	private Paid need;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Company owner;
	
	@Column
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
	private ProposalStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paid getNeed() {
		return need;
	}

	public void setNeed(Paid need) {
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

	public ProposalStatus getStatus() {
		return status;
	}

	public void setStatus(ProposalStatus status) {
		this.status = status;
	}
	
}
