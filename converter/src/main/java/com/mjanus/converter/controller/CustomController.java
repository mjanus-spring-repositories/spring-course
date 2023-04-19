package com.mjanus.converter.controller;

import com.mjanus.converter.domain.Report;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report/")
public class CustomController {

    @PostMapping(path = "add")
    public void acceptCustomTextType(@RequestBody Report report) {
        System.out.println(report.getName());
        System.out.println(report.getDescription());
        System.out.println(report.getCost());
    }
}