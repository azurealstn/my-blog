package com.azurealstn.myblog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerTest {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>hello world</h1>";
    }
}
