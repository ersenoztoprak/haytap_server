package com.ersen.unit;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ersen.entity.User;
import com.ersen.entity.builder.CompanyBuilder;
import com.ersen.entity.builder.PersonalBuilder;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.exception.EmailAlreadyInUseException;
import com.ersen.exception.InvalidRequestParametersException;
import com.ersen.exception.UsernameAlreadyTakenException;
import com.ersen.repository.UserRepository;
import com.ersen.service.UserService;
import com.ersen.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTests {

	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	private CreateUserDTO dtoWithoutUserName;
	private CreateUserDTO dtoWithoutPassword;
	private CreateUserDTO dtoWithoutEmail;
	private CreateUserDTO dtoWithInvalidEmail;
	private CreateUserDTO dtoWithInvalidPassword;
	private CreateUserDTO validDTO;
	
	@Before
	public void setup() {
		this.userService = new UserServiceImpl(userRepository);
		
		dtoWithoutUserName = new CreateUserDTO();
		dtoWithoutUserName.setUsername(null);
		
		dtoWithoutPassword = new CreateUserDTO();
		dtoWithoutPassword.setUsername("ersenoz");
		dtoWithoutPassword.setPassword(null);
		
		dtoWithoutEmail = new CreateUserDTO();
		dtoWithoutEmail.setUsername("ersenoz");
		dtoWithoutEmail.setPassword("123456789");
		dtoWithoutEmail.setEmail(null);
		
		dtoWithInvalidEmail = new CreateUserDTO();
		dtoWithInvalidEmail.setUsername("ersenoz");
		dtoWithInvalidEmail.setPassword("123456789");
		dtoWithInvalidEmail.setEmail("asdf");
		
		dtoWithInvalidPassword = new CreateUserDTO();
		dtoWithInvalidPassword.setUsername("ersenoz");
		dtoWithInvalidPassword.setEmail("abc@gmail.com");
		dtoWithInvalidPassword.setPassword("123");
		
		validDTO = new CreateUserDTO();
		validDTO.setUsername("ersenoz");
		validDTO.setPassword("123456789");
		validDTO.setEmail("abc@gmail.com");
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithNullParameter_ShouldThrowException() {
		userService.register(null);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithoutUsername_ShouldThrowException() {
		userService.register(dtoWithoutUserName);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithoutPassword_ShouldThrowException() {
		userService.register(dtoWithoutPassword);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithoutEmail_ShouldThrowException() {
		userService.register(dtoWithoutEmail);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithInvalidEmail_ShouldThrowException() {
		userService.register(dtoWithInvalidEmail);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void register_WithInvalidPassword_ShouldThrowException() {
		userService.register(dtoWithInvalidPassword);
	}
	
	@Test(expected = EmailAlreadyInUseException.class)
	public void register_WithExistingEmail_ShouldThrowException() {
		User user = new PersonalBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.of(user));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		userService.register(validDTO);
	}
	
	@Test(expected = UsernameAlreadyTakenException.class)
	public void register_WithExistingUsername_ShouldThrowException() {
		User user = new PersonalBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.of(user));
		userService.register(validDTO);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void reqister_IndividualWithoutName_ShouldThrowException () {
		User user = new PersonalBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		validDTO.setSurname("acb");
		userService.register(validDTO);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void reqister_IndividualWithoutSurname_ShouldThrowException () {
		User user = new PersonalBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		validDTO.setName("acb");
		userService.register(validDTO);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void reqister_CorporationalWithoutCompanyName_ShouldThrowException () {
		User user = new CompanyBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		validDTO.setAuthorizedPerson("adf");
		userService.register(validDTO);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void reqister_CorporationalWithoutAuthorizedPerson_ShouldThrowException () {
		User user = new CompanyBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		validDTO.setCompanyName("adf");
		userService.register(validDTO);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void reqister_InvalidUserType_ShouldThrowException () {
		User user = new CompanyBuilder().id(1L).get();
		user.setType(null);
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		userService.register(validDTO);
	}
	
	@Test
	public void register_Registered_ShouldReturnOK() {
		User user = new CompanyBuilder().id(1L).get();
		when(userRepository.findOneByEmail(validDTO.getEmail())).thenReturn(Optional.ofNullable(null));
		when(userRepository.findOneByUsername(validDTO.getUsername())).thenReturn(Optional.ofNullable(null));
		validDTO.setType(user.getType());
		validDTO.setCompanyName("adf");
		validDTO.setAuthorizedPerson("asdf");
		
		when(userRepository.save(isA(User.class))).thenAnswer(i -> {
            User r = i.getArgumentAt(0, User.class);
            r.setId(5L);
            return r;
        });
		
		User created = userService.register(validDTO);

        Assert.assertEquals(created.getId().longValue(), 5L);
	}
	
}
