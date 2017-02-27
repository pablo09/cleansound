package com.pzeszko.cleansound;

import com.pzeszko.cleansound.utils.FakeCsrfRequestFilter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        WithSecurityContextTestExecutionListener.class})
public abstract class IntegrationMockMvcTestPrototype {

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected FakeCsrfRequestFilter filter;

    protected MockMvc mockMvc;
    protected User loggedUser;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(filter)
                .apply(springSecurity())
                .build();

        loggedUser =  (User)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }


}
