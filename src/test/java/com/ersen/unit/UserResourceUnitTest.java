package com.ersen.unit;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ersen.controller.UserResource;
import com.ersen.entity.User;
import com.ersen.entity.builder.CompanyBuilder;
import com.ersen.entity.builder.PersonalBuilder;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceUnitTest {

	@Mock
    private UserService userService;
        
    private MockMvc mockMvc;
    
    private static final long ID = 1L;
    
    private CreateUserDTO validDTO;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserResource(userService)).build();
        
        validDTO = new CreateUserDTO();
		validDTO.setUsername("ersenoz");
		validDTO.setPassword("123456789");
		validDTO.setEmail("abc@gmail.com");
    }
    
    @Test
    public void createPersonalCustomer_Created_ShouldReturnResponseStatusOK() throws Exception {
    	User user = new PersonalBuilder().id(ID).get();
        
        when(userService.register(isA(CreateUserDTO.class))).thenReturn(user);
        mockMvc.perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(validDTO))).andExpect(status().isCreated());
    }
    
    @Test
    public void createCompanyCustomer_Created_ShouldReturnResponseStatusOK() throws Exception {
    	
    	User user = new CompanyBuilder().id(ID).get();
        
        when(userService.register(isA(CreateUserDTO.class))).thenReturn(user);
        mockMvc.perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(validDTO))).andExpect(status().isCreated());
    }
}
