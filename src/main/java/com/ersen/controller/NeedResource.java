package com.ersen.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ersen.entity.Need;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.dto.response.NeedDTO;
import com.ersen.service.NeedService;

@RestController
@RequestMapping(value = "/need", produces = "application/json")
@Transactional
public class NeedResource {

	private NeedService needService;

	@Autowired
	public NeedResource (NeedService needService) {
		this.needService = needService;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public NeedDTO create(@RequestBody(required = true) CreateNeedDTO dto) {
		Need need = needService.create(dto);
		return NeedDTO.fromNeed(need);
	}
}
