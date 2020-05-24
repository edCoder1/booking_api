package com.example.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    private String home(Model model) {
        model.addAttribute("username", "edCoder1");
        model.addAttribute("datetime", new Date());
        model.addAttribute("mode", "development");
        return "index" ;
    }
}
