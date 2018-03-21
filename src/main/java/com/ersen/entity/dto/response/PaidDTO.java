package com.ersen.entity.dto.response;

import java.math.BigDecimal;

import com.ersen.entity.domain.Company;
import com.ersen.entity.domain.Paid;
import com.ersen.entity.enums.NeedStatus;

public class PaidDTO extends NeedDTO {

	public BigDecimal amount;
	public Company builder;
	public NeedStatus status;
	public String code;
	
	protected PaidDTO(Paid payable) {
		super(payable);
		this.amount = payable.getAmount();
		this.builder = payable.getBuilder();
		this.status = payable.getStatus();
	}
}
