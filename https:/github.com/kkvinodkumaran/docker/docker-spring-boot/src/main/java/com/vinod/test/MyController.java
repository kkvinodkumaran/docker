package com.vinod.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MyController {

    
    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "MyDocker");
        model.addAttribute("msg", "Welcome");
        return "index";
    }

}
