package main.integration;

import static com.jayway.restassured.RestAssured.given;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ersen.entity.User;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.enums.NeedType;
import com.ersen.entity.enums.UserType;


@RunWith(SpringJUnit4ClassRunner.class)
public class NeedResourceIntegrationTests extends TestApplication {

    @Test
    public void createNeed_Created_UserShouldBeCreated() {
    	
    	CreateUserDTO validDTO = new CreateUserDTO();
		validDTO.setUsername("ersenoz");
		validDTO.setPassword("123456789");
		validDTO.setEmail("abc@gmail.com");
		validDTO.setType(UserType.INDVL);
		validDTO.setName("fsdafsfdasf");
		validDTO.setSurname("fdsdsfdsfdsfds");
    	User user = userService.register(validDTO);
    	
    	CreateNeedDTO dto = new CreateNeedDTO();
    	dto.setTitle("dsadad");
    	dto.setDescription("das");
    	dto.setCategoryId(1L);
    	dto.setOwnerId(user.getId());
    	dto.setType(NeedType.PAYABLE);
    	dto.setAmount(new BigDecimal("60"));
    	
    	given().contentType("application/json").body(dto).when().post("/need/").then().statusCode(HttpStatus.CREATED.value());
    }

}
