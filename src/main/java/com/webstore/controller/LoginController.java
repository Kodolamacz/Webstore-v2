package com.webstore.controller;

import com.webstore.domain.User;
import com.webstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Blazej on 13.03.2018.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String register(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registration")
    public String registerProcess(Model model, @ModelAttribute("user") User user, BindingResult bindingResult, Errors errors){

        User userExists = userService.findByLogin(user.getLogin());

//        if(userExists != null){
//            model.addAttribute("error","Użytkownik już istnieje");
//            return "register";
//        }
//        if(!bindingResult.hasErrors()){
//            userService.save(user);
//        }
        System.out.println("PRZED");
        userService.save(user);
        System.out.println(userService.save(user));

        return "customLogin";

    }
}
