package com.application.healthmanegmentsystem.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class ErrorController {
    @GetMapping("/accessDenied")
    public String getAccessDeniedPage(){
        return "Error/AccessDenied";
    }
}
