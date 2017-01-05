package com.pzeszko.cleansound.web;

import com.pzeszko.cleansound.dto.LoginFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Pawel on 2017-01-03.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/login")
    public String login() {
        return "account/Login";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginFormDto loginFormDto) {
        return null; //FIXME
    }

    @PostMapping("/logout")
    public String logout() {
        return "home";
    }
}
