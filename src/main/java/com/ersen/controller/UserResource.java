package com.ersen.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ersen.entity.User;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.dto.response.UserDTO;
import com.ersen.service.UserService;

@RestController
@RequestMapping(value = "/user")
@Transactional
public class UserResource {

	private UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO register(@RequestBody(required = true) CreateUserDTO dto) {
		User user = userService.register(dto);
		return UserDTO.fromUser(user);
	}
}
