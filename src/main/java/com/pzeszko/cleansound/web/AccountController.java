package com.pzeszko.cleansound.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/logout")
    public String logout() {
        return "home";
    }
}
