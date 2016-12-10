package com.ersen.service.impl;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ersen.entity.User;
import com.ersen.entity.domain.Company;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.enums.UserType;
import com.ersen.exception.EmailAlreadyInUseException;
import com.ersen.exception.InvalidRequestParametersException;
import com.ersen.exception.UncorrectUserTypeException;
import com.ersen.exception.UserNotFoundException;
import com.ersen.exception.UsernameAlreadyTakenException;
import com.ersen.repository.UserRepository;
import com.ersen.service.UserService;
import com.ersen.util.PasswordUtil;
import com.ersen.util.ValidationUtils;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;
	
	public UserServiceImpl () {
		
	}
	
	@Autowired
	public  UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User register(CreateUserDTO dto) {
		ValidationUtils.protectFromNull(dto, "createUserDTO");
		dto.validate();
		
		if (getByEmail(dto.getEmail()).isPresent())
            throw new EmailAlreadyInUseException("Specified e-mail address is already registered.");

        if (getByUsername(dto.getUsername()).isPresent())
            throw new UsernameAlreadyTakenException("Specified username has already been taken.");
		
        User user = createUser(dto);
        
		return repository.save(user);
	}
	
	private User createUser(final CreateUserDTO dto) {
        
		User newUser = null;
		
		if (dto.getType() == UserType.INDVL) {
			newUser = new Personal();
		
			if (StringUtils.isEmpty(dto.getName())) {
				throw new InvalidRequestParametersException("name must be filled for individual users");
			}
			
			if (StringUtils.isEmpty(dto.getSurname())) {
				throw new InvalidRequestParametersException("surname must be filled for individual users");
			}
			
			Personal personel = (Personal)newUser;
			personel.setName(dto.getName());
			personel.setSurname(dto.getSurname());
		}
		else if (dto.getType() == UserType.CORP) {
			newUser = new Company();
			
			Company company = (Company)newUser;
			
			if (StringUtils.isEmpty(dto.getCompanyName())) {
				throw new InvalidRequestParametersException("companyname must be filled for corporational users");
			}
			
			if (StringUtils.isEmpty(dto.getAuthorizedPerson())) {
				throw new InvalidRequestParametersException("authorized person name must be filled for corporational users");
			}
			
			company.setCompanyName(dto.getCompanyName());
			company.setAuthorizedPerson(dto.getAuthorizedPerson());
		}	
		else {
			throw new InvalidRequestParametersException("unrecognized user type");
		}
		
        newUser.setPassword(PasswordUtil.encode(dto.getPassword()));
        newUser.setEmail(dto.getEmail());
        newUser.setUsername(dto.getUsername());
        newUser.setPhone(dto.getPhone());

        User result = repository.save(newUser);

        return result;
    }
	
	/**
     * Attempts to find a user by their e-mail.
     * 
     * @param email the e-mail address
     * @return an Optional<User> that contains the user (if found), or is empty otherwise
     */
    public Optional<User> getByEmail(String email) {
        return repository.findOneByEmail(email);
    }

    //TODO return also authorities!!!
	public Optional<User> getByUsername(String username) {
        return repository.findOneByUsername(username);
    }

	public User getUser(long id) {
		return repository.findOneById(id).orElseThrow(() -> new UserNotFoundException());
	}
	
	@Override
	public Personal getPersonalUser(long id) {
		User user = getUser(id);
		if (!user.isPersonal())
			throw new UncorrectUserTypeException("user must be personal");
		
		return (Personal)user;
	}

}
