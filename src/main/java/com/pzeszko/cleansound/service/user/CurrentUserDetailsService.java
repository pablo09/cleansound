package com.pzeszko.cleansound.service.user;

import com.pzeszko.cleansound.exception.NotFoundException;
import com.pzeszko.cleansound.model.CurrentUser;
import com.pzeszko.cleansound.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @PostConstruct
    public void test() {

    }
    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try {
             user = userService.findUser(email);
        } catch(NotFoundException e) {
            log.warn("User with email {} not found", email);
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }

        return new CurrentUser(user);
    }
}