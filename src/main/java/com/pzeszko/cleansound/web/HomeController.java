package com.pzeszko.cleansound.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pawel on 2017-01-02.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {return "home";}
}
