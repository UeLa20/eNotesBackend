package com.example.enotes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String home() {
        return "API WORKING";
    }

    @GetMapping("/test")
    public String test() {
        return "BACKEND ENOTES OK";
    }

}
