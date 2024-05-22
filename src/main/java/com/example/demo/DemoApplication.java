package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(value = "/hi/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetPerson(@PathVariable(name = "name") String name) {
        if (name == "") {
            throw new InvalidParameterException(" Please provide correct parameter ");
        }
        String lastName = getLastName();
        return "hello " + name + " " + lastName;
    }

    @GetMapping(value = "/{name}/age")
    public int getAge(@PathVariable(name = "name") String name) {
        return (int) Math.random();
    }


    private String getLastName() {
        return "Kumar";
    }
}


