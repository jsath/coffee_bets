package com.project.cofeebets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StadiumController {
     
    public StadiumController() {
    }
    
    
    @GetMapping("/patstest")
    public String pat() {
        return "showallbets.jsp";
    }
    @GetMapping("/jeffstest")
    public String jeff() {
        return "showallbets.jsp";
    }
}