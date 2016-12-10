package com.ersen.service;

import com.ersen.entity.User;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.dto.request.CreateUserDTO;

public interface UserService {

	User register(CreateUserDTO dto);

	Personal getPersonalUser(long id);

}
