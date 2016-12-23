package main.integration;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ersen.Application;
import com.ersen.service.UserService;
import com.jayway.restassured.RestAssured;

@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("fast")
@IntegrationTest("server.port:0")
@Transactional
public abstract class TestApplication {

    @Value("${local.server.port}")
    protected int serverPort;

    @Autowired
    protected UserService userService;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = serverPort;
    }
}
