package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public @ResponseBody String greeting(){
        return "Hello, DevOps!";
    }
    @GetMapping("/home")
    public @ResponseBody String greetingHome(){
        return "Hello, Home!";
    }
}
