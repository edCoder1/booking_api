package com.example.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    private String home() {
        return "index" ;
    }
}
