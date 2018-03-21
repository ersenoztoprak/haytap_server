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

import com.ersen.controller.NeedResource;
import com.ersen.entity.Need;
import com.ersen.entity.builder.FreeBuilder;
import com.ersen.entity.builder.PaidBuilder;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.enums.UserType;
import com.ersen.service.NeedService;

@RunWith(MockitoJUnitRunner.class)
public class NeedResourceUnitTests {

	@Mock
	private NeedService needService;
	
	private MockMvc mockMvc;
	
	CreateUserDTO  dto = null;
	
	private static final long ID = 1L;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new NeedResource(needService)).build(); 
		
		dto = new CreateUserDTO();
        dto.setUsername("deneme9");
        dto.setPassword("123456");
        dto.setEmail("deneme9@deneme.com");
        dto.setPhone("5322605648");
        dto.setType(UserType.INDVL);
        dto.setName("Ersen");
        dto.setSurname("Öztoprak");
	}
	
	@Test
    public void createPayableNeed_Created_ShouldReturnResponseStatusOK() throws Exception {
    	Need need = new PaidBuilder().id(ID).get();
        
        when(needService.create(isA(CreateNeedDTO.class))).thenReturn(need);
        mockMvc.perform(post("/need/").contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }
    
    @Test
    public void createFreeNeed_Created_ShouldReturnResponseStatusOK() throws Exception {
    	
    	Need need = new FreeBuilder().id(ID).get();
        
        when(needService.create(isA(CreateNeedDTO.class))).thenReturn(need);
        mockMvc.perform(post("/need/").contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }
}
