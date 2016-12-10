package com.ersen.entity.builder;

import com.ersen.entity.domain.Payable;

public class PayableBuilder extends NeedBuilder{

	public PayableBuilder () {
		need = new Payable();
	}
}
