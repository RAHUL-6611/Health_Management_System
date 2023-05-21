package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Services.ServicesImplementation.PatientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController {
    @Autowired
    private PatientServicesImpl userServices;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String getLogin(@ModelAttribute("userInfo") UserInfo userInfo){
        return "Auth/Login";
    }

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("userInfo") UserInfo userInfo){
        return "Auth/Registration";
    }


    @PostMapping("/process-registration")
    public String processRegistration(UserInfo userPatient){
        System.out.println(userPatient);
        userPatient.setPassword(passwordEncoder.encode(userPatient.getPassword()));
        String result = userServices.processRegistration(userPatient);
        return "redirect:/login";
    }

}
