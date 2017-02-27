package com.pzeszko.cleansound.web;

import com.pzeszko.cleansound.IntegrationMockMvcTestPrototype;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Pawel on 2017-02-01.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest extends IntegrationMockMvcTestPrototype {

    @Test
    @WithUserDetails("user@user.com")
    public void shouldFirstlyGetAccountInfo() throws Exception {
        mockMvc
                .perform(get("/account/info")
                        .with(user(loggedUser)))
                .andExpect(status().is(200))
                .andExpect(view().name("account/info"))
                .andExpect(model().attribute("user", hasProperty("email", is("user@user.com"))))
                .andExpect(model().attribute("user", hasProperty("active", is(false))));
    }

    @Test
    @WithUserDetails("user@user.com")
    public void shouldSecondlyUpdateAccount() throws Exception {
        mockMvc
                .perform(post("/account/update")
                        .param("email", "user123@user.com")
                        .param("active", "true")
                        .with(user(loggedUser)))
                .andExpect(status().is(302));
    }

    @Test
    @WithUserDetails("user123@user.com")
    public void shouldThirdly() throws Exception {
        mockMvc
                .perform(get("/account/info")
                        .with(user(loggedUser)))
                .andExpect(status().is(200))
                .andExpect(view().name("account/info"))
                .andExpect(model().attribute("user", hasProperty("email", is("user123@user.com"))))
                .andExpect(model().attribute("user", hasProperty("active", is(true))));
    }
}
