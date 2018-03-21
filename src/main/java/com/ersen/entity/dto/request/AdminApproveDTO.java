package com.ersen.entity.dto.request;

import com.ersen.entity.enums.AdminStatus;
import com.ersen.util.NumberUtils;

public class AdminApproveDTO {
	
	private Long adminId;
	private AdminStatus status;
	
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public AdminStatus getStatus() {
		return status;
	}
	public void setStatus(AdminStatus status) {
		this.status = status;
	}
	public void validate() {
		if (NumberUtils.isZero(adminId))
			throw new RuntimeException();
		
		if (status == null)
			throw new RuntimeException();
		
	}
	
	
}
