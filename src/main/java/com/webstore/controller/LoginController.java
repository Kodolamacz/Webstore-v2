package com.webstore.controller;

import com.webstore.domain.User;
import com.webstore.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Blazej on 13.03.2018.
 */
@Controller
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String register(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registration")
    public String registerProcess(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.save(user);

        return "customLogin";

    }
    @PostMapping("/userPage")
    public String getUserPage(){
        return "userPage";
    }
//    @InitBinder
//    public void initialiseBinder(WebDataBinder binder) {
//        binder.setAllowedFields("firstName", "lastName", "login", "password", "email");
//    }
}
