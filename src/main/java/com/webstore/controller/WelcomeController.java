package com.webstore.controller;

import com.webstore.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Blazej on 24.01.2018.
 */
@Controller
public class WelcomeController {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private RoleRepository userRepository;

    @RequestMapping(value = "/welcome")
    public String welcome(Model model){
//        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("hello","TEST");//context.getAuthentication().getName());
        return "welcome";

    }

//    @GetMapping("/login")
//    public String login(){
//        return "customLogin";
//    }
//
//    @PostMapping("/login")
//    public String loginProcess(Model model ){
//     //   model.addAttribute("hello", principal.getName());
//        return "welcome";
//   }
}
