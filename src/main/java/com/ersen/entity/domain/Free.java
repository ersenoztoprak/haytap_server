package com.ersen.entity.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ersen.entity.Need;
import com.ersen.entity.enums.NeedType;

@Entity
@DiscriminatorValue(value = "FREE")
public class Free extends Need {

	public Free() {
		setType(NeedType.FREE);
	}
}
