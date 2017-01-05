package com.pzeszko.cleansound.web;

import com.pzeszko.cleansound.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pawel on 2017-01-02.
 */
@Controller
@RequestMapping("/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {
    
    private final UserService userService;

    @GetMapping
    public String home() {
        return "home";}
}
