package com.ersen.entity.dto.response;

import com.ersen.entity.Category;
import com.ersen.entity.Need;
import com.ersen.entity.domain.Free;
import com.ersen.entity.domain.Paid;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.enums.AdminStatus;

public class NeedDTO {

    public Long id;
	public String title;
	public String description;
	public Personal owner;
	public Category category;
	public AdminStatus adminStatus;
	
	protected NeedDTO (Need need) {
		this.id = need.getId();
		this.title = need.getTitle();
		this.description = need.getDescription();
		this.owner = need.getOwner();
		this.category = need.getCategory();
		this.adminStatus = need.getAdminStatus();
	}
	
	public static NeedDTO fromNeed(Need need) {
		if (need instanceof Paid) {
			return new PaidDTO((Paid)need);
		}
		else {
			return new FreeDTO((Free)need);
		}
	}

}
