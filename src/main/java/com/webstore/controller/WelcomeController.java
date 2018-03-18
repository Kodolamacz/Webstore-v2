package com.webstore.controller;

import com.webstore.dao.RoleRepository;
import com.webstore.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Blazej on 24.01.2018.
 */
@Controller
public class WelcomeController {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private RoleRepository userRepository;

    @GetMapping(value = "/welcome")
    public String welcome(Model model){
        model.addAttribute("hello","TEST");
        return "welcome";

    }

    @GetMapping("/login")
    public String login(){
        return "customLogin";
    }

    @PostMapping("/login")
    public String loginProcess(Model model ){
     //   model.addAttribute("hello", principal.getName());
        return "welcome";
   }
}
