package com.pzeszko.cleansound.web;

import com.pzeszko.cleansound.IntegrationMockMvcTestPrototype;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Pawel on 2017-02-01.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest extends IntegrationMockMvcTestPrototype {
   // public class AccountControllerTest extends IntegrationTestPrototype {

    @Test
    @WithMockUser(username = "user@user.com", authorities = {"USER"})
    public void should_get_early_repayment() throws Exception {

        mockMvc
                .perform(post("/account/update")
                        .param("email", "user123@user.com")
                        .param("active", "true")
                        .with(user("user@user.com").password("pass")))

                .andExpect(status().is(302));
    }

    @Ignore
    @Test
    public void shoulFirstlydUpdateAccount() {
        given()
                .auth().basic("user@user.com", "pass")
               // .header("Accept-Encoding", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParameters(createUserUpdateForm())
        .when().
                post("account/update")
        .then()
                .assertThat()
                .statusCode(302);
    }

    @Ignore
    @Test
    public void shouldSecondlyReturnUpdatedDataaccount() {
        given()
                .auth().basic("user@user.com", "pass")
               // .header("Accept-Encoding", "application/json")
                //.contentType("application/json")
        .when().
                get("account/info")
        .then()
                .assertThat()
                .statusCode(200)
                .body("email", equalTo("user@user.com"))
                .body("password", equalTo("pass"))
                .body("active", equalTo(true));
    }

    public Map<String, Object> createUserUpdateForm() {
        Map<String, Object> params = new HashMap<>();
        params.put("email", "user123@user.com");
        params.put("active", true);

        return params;
    }
}
