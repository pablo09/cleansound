package com.pzeszko.cleansound.web.handler;

import com.pzeszko.cleansound.model.CurrentUser;
import com.pzeszko.cleansound.model.User;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Pawel on 2017-01-08.
 */

@ControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GlobalModelHandler {

    private final Mapper mapper;

    @ModelAttribute("navbarUser")
    public User getUser(@AuthenticationPrincipal CurrentUser user) {
       if(user != null) {
           return user.getUser();
       }

       return null;
    }
}
