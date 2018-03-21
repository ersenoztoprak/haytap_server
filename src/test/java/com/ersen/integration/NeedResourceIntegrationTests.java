package com.ersen.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import com.ersen.entity.Category;
import com.ersen.entity.User;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.enums.NeedType;
import com.ersen.entity.enums.UserType;

public class NeedResourceIntegrationTests extends BaseIntegrationTest {

	private Category category;
	private User user;
	
	@Before
	public void setup() {
		category = new Category();
    	category.setName("derberder");
    	category.setPaid(false);
    	categoryRepository.save(category);
    	
    	CreateUserDTO validDTO = new CreateUserDTO();
		validDTO.setUsername("ersenoz");
		validDTO.setPassword("123456789");
		validDTO.setEmail("abc@gmail.com");
		validDTO.setType(UserType.INDVL);
		validDTO.setName("fsdafsfdasf");
		validDTO.setSurname("fdsdsfdsfdsfds");
    	user = userService.register(validDTO);
	}
	
    @Test
    public void createNeed_Created_NeedShouldBeCreated() throws Exception {

    	CreateNeedDTO dto = new CreateNeedDTO();
    	dto.setTitle("dsadad");
    	dto.setDescription("das");
    	dto.setCategoryId(category.getId());
    	dto.setOwnerId(user.getId());
    	dto.setType(NeedType.PAID);
    	dto.setAmount(new BigDecimal("60"));
    	
    	mvc.perform(post("/need/")
    			.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(dto)))
    			.andExpect(status().isCreated());
    }

}
