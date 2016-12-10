package main.integration;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ersen.entity.User;
import com.ersen.entity.dto.request.CreateUserDTO;
import com.ersen.entity.enums.UserType;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserResourceIntegrationTests extends TestApplication {

    @Test
    public void registerUser_Registered_UserShouldBeCreated() {
    	
        CreateUserDTO  dto = new CreateUserDTO();
        dto.setUsername("deneme9");
        dto.setPassword("123456");
        dto.setEmail("deneme9@deneme.com");
        dto.setPhone("5322605648");
        dto.setType(UserType.INDVL);
        dto.setName("Ersen");
        dto.setSurname("Öztoprak");

        given().contentType("application/json").body(dto).when().post("/user/").then().statusCode(HttpStatus.OK.value());

        User user = userRepository.findOneByEmail(dto.getEmail()).get();
        Assert.assertNotNull(user);
    }

}
