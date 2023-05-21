package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.*;
import com.application.healthmanegmentsystem.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")

public class ServicesController {
    @Autowired
    PatientServices patientServices;
    @GetMapping()
    public String getServicesPage(){
        return "View/Services";
    }

    @GetMapping("/freeCheckup")
    public String getServicesFreeCheckupPage(@ModelAttribute("freecheckupInfo")FreeCheckupService freeCheckupService){
        return "ServicesForm/FreeCheckup";
    }
    @PostMapping("/applyFreeCheckup")
    public String applyFreeCheckupPage(@Valid @ModelAttribute("freecheckupInfo")FreeCheckupService freeCheckupService , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "redirect:/services/freeCheckup?error";
        }
        patientServices.saveFreeCheckupService(freeCheckupService, auth.getName());
        return "redirect:/services/freeCheckup?sucess";
    }

    @GetMapping("/ambulance")
    public String getServicesAmbulancePage(@ModelAttribute("ambulanceInfo")AmbulanceService ambulanceService){

        return "ServicesForm/Ambulance";
    }
    @PostMapping("/applyAmbulance")
    public String applyAmbulancePage(@Valid @ModelAttribute("ambulanceInfo")AmbulanceService ambulanceService , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "redirect:/services/ambulance?error";
        }
        patientServices.saveAmbulanceService(ambulanceService, auth.getName());
        return "redirect:/services/ambulance?sucess";
    }


    @GetMapping("/medicines")
    public String getServicesMedicinesPage(@ModelAttribute("medicineInfo")MedicineService medicineService){
        return "ServicesForm/Medicines";
    }
    @PostMapping("/applyMedicines")
    public String applyMedicinesPage(@Valid @ModelAttribute("medicineInfo")MedicineService medicineService , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "redirect:/services/medicines?error";
        }
        patientServices.saveMedicineService(medicineService, auth.getName());
        return "redirect:/services/medicines?sucess";
    }


    @GetMapping("/bedFacility")
    public String getServicesBedFacilityPage(@ModelAttribute("bedFacilityInfo")BedFacilityService bedFacilityService){
        return "ServicesForm/BedFacility";
    }
    @PostMapping("/applyBedFacility")
    public String applyBedFacilityPage(@Valid @ModelAttribute("bedFacilityInfo")BedFacilityService bedFacilityService , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "redirect:/services/bedFacility?error";
        }
        patientServices.saveBedFacilityService(bedFacilityService, auth.getName());
        return "redirect:/services/bedFacility?sucess";
    }

    @GetMapping("/totalCare")
    public String getServicesTotalCarePage(@ModelAttribute("totalCareInfo")TotalcareService totalcareService){
        return "ServicesForm/TotalCare";
    }
    @PostMapping("/applyTotalCare")
    public String applyTotalCarePage(@Valid @ModelAttribute("totalCareInfo")TotalcareService totalcareService , BindingResult result , Authentication auth){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "redirect:/services/totalCare?error";
        }
        patientServices.saveTotalcareService(totalcareService, auth.getName());
        return "redirect:/services/totalCare?sucess";
    }


}
