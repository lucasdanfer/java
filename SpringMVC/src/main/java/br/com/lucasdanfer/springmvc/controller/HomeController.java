package br.com.lucasdanfer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    private static final String HOME = "home";

    @RequestMapping("/")
    public String index(){
        return HOME;
    }
    
}
