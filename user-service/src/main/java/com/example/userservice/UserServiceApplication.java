package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping("/info")
    public String info(@Value("${server.port}") String port) {
        return "User 서비스의 기본 동작 Port: {" + port + "}";
    }

    @GetMapping("/auth")
    public String auth(@RequestHeader(value = "token") String token) {
        return "token is " + token;
    }
}
