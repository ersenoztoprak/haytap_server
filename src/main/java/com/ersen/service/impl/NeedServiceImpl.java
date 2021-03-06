package com.ersen.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ersen.entity.Category;
import com.ersen.entity.Need;
import com.ersen.entity.domain.Free;
import com.ersen.entity.domain.Paid;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.dto.request.AdminApproveDTO;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.enums.AdminStatus;
import com.ersen.entity.enums.NeedStatus;
import com.ersen.entity.enums.NeedType;
import com.ersen.exception.InvalidRequestParametersException;
import com.ersen.repository.NeedRepository;
import com.ersen.service.CategoryService;
import com.ersen.service.NeedService;
import com.ersen.service.UserService;
import com.ersen.util.NumberUtils;
import com.ersen.util.ValidationUtils;

@Service
public class NeedServiceImpl implements NeedService{

	private NeedRepository needRepository;

	private UserService userService;

	private CategoryService categoryService;

	@Autowired
	public NeedServiceImpl (UserService userService, CategoryService categoryService, NeedRepository needRepository) {
		this.userService = userService;
		this.needRepository = needRepository;
		this.categoryService = categoryService;
	}

	@Override
	public Need create(CreateNeedDTO dto) {
		ValidationUtils.protectFromNull(dto, "createNeedDTO");
		dto.validate();

		Personal owner = userService.getPersonalUser(dto.getOwnerId());
		Category category = categoryService.getCategory(dto.getCategoryId());

		Need newNeed = null;

		if (dto.getType() == NeedType.PAID) {
			newNeed = new Paid();

			if (dto.getAmount() == null || dto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
				throw new InvalidRequestParametersException("amount must be greater than zero");
			} 

			Paid payable = (Paid)newNeed;
			payable.setAmount(dto.getAmount());
			payable.setStatus(NeedStatus.WAITING_PROPOSAL);
		}
		else {
			newNeed = new Free();
		}

		newNeed.setCategory(category);
		newNeed.setTitle(dto.getTitle());
		newNeed.setDescription(dto.getDescription());
		newNeed.setOwner(owner);
		newNeed.setAdminStatus(AdminStatus.PENDING);

		return needRepository.save(newNeed);
	}

	@Override
	public void approve(Long id, AdminApproveDTO dto) {
		if (NumberUtils.isZero(id))
			throw new RuntimeException(); 
		
		dto.validate();
		
		Need need = getNeedById(id);
		
		if (!need.waitingAdminCheck()) {
			throw new RuntimeException();
		}
		
		needRepository.approve(id, dto.getStatus());
	}

	private Need getNeedByIdUnSafe(Long id) {
		return needRepository.findOne(id);
	}
	
	private Need getNeedById(Long id) {
		Need need = getNeedByIdUnSafe(id);
		if (need == null)
			throw new RuntimeException();
		
		return need;
	}
	

}
