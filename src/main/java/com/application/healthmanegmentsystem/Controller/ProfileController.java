package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Services.ServicesImplementation.PatientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")

public class ProfileController {
    @Autowired
    private PatientServicesImpl patientServices;
    @GetMapping()
    public String getUserpage(Authentication auth , Model model){
        UserInfo userInfo = patientServices.getLogedInUserDetailss(auth.getName());
        model.addAttribute("logInfoDetails",userInfo);
        return "Auth/Profile";
    }
    @PostMapping("/processDetailsUpdate")
    public String UpdateProfile(UserInfo userInfo ){
        patientServices.updateProfile(userInfo);
        return "redirect:/Auth/Profile?sucess=true";
    }
}
