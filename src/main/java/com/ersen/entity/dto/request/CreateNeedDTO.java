package com.ersen.entity.dto.request;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.ersen.entity.enums.NeedType;
import com.ersen.exception.InvalidRequestParametersException;
import com.ersen.util.ValidationUtils;

public class CreateNeedDTO {

	private String title;
	
	private String description;
	
	private Long categoryId;
	
	private Long ownerId;
	
	private NeedType type;
	
	private BigDecimal amount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public NeedType getType() {
		return type;
	}

	public void setType(NeedType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void validate() {
		ValidationUtils.protectFromNull(title, "title");
		ValidationUtils.protectFromNull(description, "description");
		ValidationUtils.protectFromNull(ownerId, "ownerId");
		ValidationUtils.protectFromNull(categoryId, "categoryId");
		ValidationUtils.protectFromNull(type, "type");
		
		if (StringUtils.isEmpty(title)) {
			throw new InvalidRequestParametersException("title must not be empty");
		}
		
		if (StringUtils.isEmpty(description)) {
			throw new InvalidRequestParametersException("description must not be empty");
		}
		
		if (ownerId <= 0) {
			throw new InvalidRequestParametersException("owner id must be greater than zero");
		}
		
		if (categoryId <= 0) {
			throw new InvalidRequestParametersException("category id must be greater than zero");
		}
		
		if (type != NeedType.FREE && type != NeedType.PAID) {
			throw new InvalidRequestParametersException("unrecognized need type!");
		}
	}
	
}
