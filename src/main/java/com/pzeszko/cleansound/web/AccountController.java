package com.pzeszko.cleansound.web;

import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.model.CurrentUser;
import com.pzeszko.cleansound.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pawel on 2017-01-03.
 */
@Controller
@RequestMapping("/account")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "account/Login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "home";
    }

    @GetMapping("/info")
    public String info(Model model, @AuthenticationPrincipal CurrentUser user) {
        model.addAttribute("user", accountService.findUserData(user.getUser().getEmail()));
        return "account/info";
    }

    @PostMapping("/update")
    public String update(UserDto userDto, @AuthenticationPrincipal CurrentUser user) {
        accountService.updateUserInfo(userDto, user.getUser());
        return "redirect:/account/info";
    }
}
