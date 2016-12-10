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

import com.ersen.entity.domain.Payable;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.enums.SupportStatus;

@Entity
@Table(name = "supporters")
public class Supporter {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "need_id")
	private Payable supportedNeed;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Personal supporter;
	
	@Column
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
	private SupportStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payable getSupportedNeed() {
		return supportedNeed;
	}

	public void setSupportedNeed(Payable supportedNeed) {
		this.supportedNeed = supportedNeed;
	}

	public Personal getSupporter() {
		return supporter;
	}

	public void setSupporter(Personal supporter) {
		this.supporter = supporter;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public SupportStatus getStatus() {
		return status;
	}

	public void setStatus(SupportStatus status) {
		this.status = status;
	}
	
}
