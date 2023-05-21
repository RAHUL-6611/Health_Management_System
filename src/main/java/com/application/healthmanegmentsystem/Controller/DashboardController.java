package com.application.healthmanegmentsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DashboardController {
    @GetMapping("/")
    public String getDashBoardPage(){
        return "View/Home";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "View/About";
    }


    @GetMapping("/doctor")
    public String getDoctorPage(){
        return "View/Doctor";
    }
}
