package com.joffredupreez.flashcardapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "login", method = RequestMethod.GET)
    public String loadLoginPage (ModelMap model) {
        return "login";
    }


    @RequestMapping(path = "register", method = RequestMethod.GET)
    public String loadRegisterPage (ModelMap model) {
        return "register";
    }


    @RequestMapping(path = "register", method = RequestMethod.POST)
    public String createNewUser (@RequestBody MultiValueMap<String, String> formData) {
        userService.createUser(formData.getFirst("username"), formData.getFirst("password"));

        return "redirect:login";
    }



}
