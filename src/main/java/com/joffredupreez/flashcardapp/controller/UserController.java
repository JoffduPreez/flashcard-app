package com.joffredupreez.flashcardapp.controller;

import com.joffredupreez.flashcardapp.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
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

import java.io.UnsupportedEncodingException;

import static org.springframework.web.util.WebUtils.getRealPath;

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
    public String createNewUser (@RequestBody MultiValueMap<String, String> formData, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
        try {
            String username = formData.getFirst("username");
            String email = formData.getFirst("email");

            userService.createUser(username, email, formData.getFirst("password"), getSiteURL(request));
            // redirectAttributes.addFlashAttribute("successMessage", "Account created successfully! Please login with your newly created account");
            redirectAttributes.addFlashAttribute("email", email);

            return "redirect:verify";
        } catch (IllegalArgumentException e) {
            // Handle the exception, e.g., by adding a flash attribute and redirecting back to the registration form
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:register";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "verify", method = RequestMethod.GET)
    public String loadVerifyPage (Model model) {
        model.addAttribute("email", model.getAttribute("email"));

        return "verify";
    }


    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }



}
