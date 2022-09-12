package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String getMessage() {
        return "Welcome to demo home!";
    }

    @GetMapping("/balance")
    public String getBalance() {
        return "Your balance is Rs.100.00";
    }

    @GetMapping("/statement")
    public String getStmt() {
        return "Statement has been sent to your email id!";
    }

    @GetMapping("/loan")
    public String getLoan() {
        return "Your loan amount due is Rs.1,00,000!";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "Our contact is 1234@gmail.com!";
    }

}
