package com.example.retrydbconndemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String test() {
        return "Hello!";
    }
}
