package com.mongodb.project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldContrroller {

    public String firstPage(){
        return "Hello World";
    }
}
