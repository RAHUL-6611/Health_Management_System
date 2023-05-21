package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.Appointment;
import com.application.healthmanegmentsystem.Services.ServicesImplementation.PatientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class ApppointmentController {
    @Autowired
    private PatientServicesImpl patientServices;
    @GetMapping("/bookAppointment")
    public String getAppointmentPage(@ModelAttribute("appointmentInfo")Appointment appointment){
        return "View/BookAppointment";
    }
    @PostMapping("/applyAppointment")
    public String saveAppointmeent(@Valid @ModelAttribute("appointmentInfo") Appointment appointment , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "View/BookAppointment";
        }
        patientServices.saveAppoinment(appointment,auth.getName());
        return "redirect:/bookAppointment?sucess=true";
    }
}
