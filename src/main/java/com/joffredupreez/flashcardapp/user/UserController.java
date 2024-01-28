package com.joffredupreez.flashcardapp.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(path = "login", method = RequestMethod.GET)
    public String loadLoginPage (ModelMap model) {
        return "login";
    }

    @RequestMapping(path = "register", method = RequestMethod.GET)
    public String loadRegisterPage (ModelMap model) {
        return "register";
    }
}
