package com.pzeszko.cleansound;

import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Base class for integration test
 */
@RunWith(SpringRunner.class)
@Transactional()
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestPrototype {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
        setUpRestAssured();
    }

    protected void setUpRestAssured() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = Integer.getInteger("http.port", port);

    }

    @After
    public void tearDown() throws IOException {
        RestAssured.reset();
    }
}
