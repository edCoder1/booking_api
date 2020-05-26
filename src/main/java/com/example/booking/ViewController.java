package com.example.booking;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    private String appMode;


    // Using dependency injection to inject environment property from configuration
    public ViewController(Environment env) {
        appMode = env.getProperty("app-mode");
    }

    @RequestMapping(value = "/")
    private String home(Model model) {
        model.addAttribute("username", "edCoder1");
        model.addAttribute("datetime", new Date());
        model.addAttribute("mode", appMode);
        return "index" ;
    }
}
