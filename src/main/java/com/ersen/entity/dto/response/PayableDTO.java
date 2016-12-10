package com.ersen.entity.dto.response;

import java.math.BigDecimal;

import com.ersen.entity.domain.Company;
import com.ersen.entity.domain.Payable;
import com.ersen.entity.enums.NeedStatus;

public class PayableDTO extends NeedDTO {

	public BigDecimal amount;
	public Company builder;
	public NeedStatus status;
	public String code;
	
	protected PayableDTO(Payable payable) {
		super(payable);
		this.amount = payable.getAmount();
		this.builder = payable.getBuilder();
		this.status = payable.getStatus();
		this.code = payable.getCode();
	}
}
