package com.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Blazej on 24.01.2018.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome")
    public String welcome(Model model){

        model.addAttribute("hello","hello");
        return "welcome";

    }
}
