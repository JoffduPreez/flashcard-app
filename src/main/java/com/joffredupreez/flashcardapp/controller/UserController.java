package com.joffredupreez.flashcardapp.controller;

import com.joffredupreez.flashcardapp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(path = "login", method = RequestMethod.GET)
    public String loadLoginPage (Model model) {
        if (model.containsAttribute("errorMessage")) {
            String errorMessage = (String) model.getAttribute("errorMessage");
            model.addAttribute("errorMessage", errorMessage);
        }

        return "login";
    }


    @RequestMapping(path = "register", method = RequestMethod.GET)
    public String loadRegisterPage (Model model) {
        if (model.containsAttribute("errorMessage")) {
            String errorMessage = (String) model.getAttribute("errorMessage");
            model.addAttribute("errorMessage", errorMessage);
        }

        return "register";
    }


    @RequestMapping(path = "register", method = RequestMethod.POST)
    public String createNewUser (@RequestBody MultiValueMap<String, String> formData, RedirectAttributes redirectAttributes) {
        try {
            userService.createUser(formData.getFirst("username"), formData.getFirst("email"), formData.getFirst("password"));
            
            redirectAttributes.addFlashAttribute("successMessage", "Account created successfully! Please login with your newly created account");
            return "redirect:login";
        } catch (IllegalArgumentException e) {
            // Handle the exception, e.g., by adding a flash attribute and redirecting back to the registration form
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:register";
        }

    }



}
