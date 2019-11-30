package com.example.jenkinstest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Jenkinstest2Application {

    public static void main(String[] args) {
        SpringApplication.run(Jenkinstest2Application.class, args);
    }

    @GetMapping("/info")
    public String method(){
        return "ok";
    }
}
