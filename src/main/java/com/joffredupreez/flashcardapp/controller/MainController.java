package com.joffredupreez.flashcardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String loadStartPage () {
        return "login";
    }
}
