package com.application.healthmanegmentsystem.Controller;

import com.application.healthmanegmentsystem.Entity.*;
import com.application.healthmanegmentsystem.Services.ServicesImplementation.PatientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    @Autowired
    private PatientServicesImpl patientServices;
    @GetMapping()
    public String getAdminDashboard(Model model){
        List<UserInfo> userInfoList = patientServices.getAllUser();
        model.addAttribute("patients",userInfoList);
        return "Auth/AdminDashboard";
    }
    @GetMapping("/ambulanceRequest")
    public String getAmbulanceRequest(Model model){
        List<AmbulanceService> ambulanceServices = patientServices.getAllAmbulanceService() ;
        model.addAttribute("ambulanceServiceList",ambulanceServices);
        return "Auth/AdminRequestView/AmbulanceRequest";
    }
    @GetMapping("/acceptambulanceRequest/{id}")
    public String acceptAmbulanceRequest(@PathVariable("id") Long id){
        patientServices.acceptAmbulanceServiceById(id);
        return "redirect:/admin/ambulanceRequest";
    }
    @GetMapping("/rejectambulanceRequest/{id}")
    public String rejectAmbulanceRequest(@PathVariable("id") Long id){
        patientServices.rejectAmbulanceServiceById(id);
        return "redirect:/admin/ambulanceRequest";
    }
    @GetMapping("/deleteambulanceRequest/{id}")
    public String deleteAmbulanceRequest(@PathVariable("id") Long id){
        patientServices.deleteAmbulanceServiceById(id);
        return "redirect:/admin/ambulanceRequest";
    }
    @GetMapping("/bedFacilityRequest")
    public String getBedFacilityRequest(Model model){
        List<BedFacilityService> bedFacilityServices = patientServices.getAllBedFacilityService() ;
        model.addAttribute("bedFacilityServicesList",bedFacilityServices);
        return "Auth/AdminRequestView/BedFacilityRequest";
    }
    @GetMapping("/acceptbedFacilityRequest/{id}")
    public String acceptBedFacilityRequest(@PathVariable("id") Long id){
        patientServices.acceptBedFacilityServiceById(id);
        return "redirect:/admin/bedFacilityRequest";
    }
    @GetMapping("/rejectbedFacilityRequest/{id}")
    public String rejectBedFacilityRequest(@PathVariable("id") Long id){
        patientServices.rejectBedFacilityServiceById(id);
        return "redirect:/admin/bedFacilityRequest";
    }
    @GetMapping("/deletebedFacilityRequest/{id}")
    public String deleteBedFacilityRequest(@PathVariable("id") Long id){
        patientServices.deleteBedFacilityServiceById(id);
        return "redirect:/admin/bedFacilityRequest";
    }
    @GetMapping("/medicineRequest")
    public String getMedicineRequest(Model model){
        List<MedicineService> medicineServices = patientServices.getAllMedicineService() ;
        model.addAttribute("medicineServicesList",medicineServices);
        return "Auth/AdminRequestView/MedicineRequest";
    }
    @GetMapping("/acceptmedicineRequest/{id}")
    public String acceptMedicineRequest(@PathVariable("id") Long id){
        patientServices.acceptMedicineServiceById(id);
        return "redirect:/admin/medicineRequest";
    }
    @GetMapping("/rejectmedicineRequest/{id}")
    public String rejectMedicineRequest(@PathVariable("id") Long id){
        patientServices.rejectMedicineServiceById(id);
        return "redirect:/admin/medicineRequest";
    }
    @GetMapping("/deletemedicineRequest/{id}")
    public String deleteMedicineRequest(@PathVariable("id") Long id){
        patientServices.deleteMedicineServiceById(id);
        return "redirect:/admin/medicineRequest";
    }
    @GetMapping("/freeCheckupRequest")
    public String getFreeCheckupRequest(Model model){
        List<FreeCheckupService> freeCheckupServices = patientServices.getAllFreeCheckupService() ;
        model.addAttribute("freeCheckupServicesList",freeCheckupServices);
        return "Auth/AdminRequestView/FreeCheckupRequest";
    }
    @GetMapping("/acceptfreeCheckupRequest/{id}")
    public String acceptFreeCheckupRequest(@PathVariable("id") Long id){
        patientServices.acceptFreeCheckupServiceById(id);
        return "redirect:/admin/freeCheckupRequest";
    }
    @GetMapping("/rejectfreeCheckupRequest/{id}")
    public String rejectFreeCheckupRequest(@PathVariable("id") Long id){
        patientServices.rejectFreeCheckupServiceById(id);
        return "redirect:/admin/freeCheckupRequest";
    }
    @GetMapping("/deletefreeCheckupRequest/{id}")
    public String deleteFreeCheckupRequest(@PathVariable("id") Long id){
        patientServices.deleteFreeCheckupServiceById(id);
        return "redirect:/admin/freeCheckupRequest";
    }
    @GetMapping("/totalCareRequest")
    public String getTotalCareRequest(Model model){
        List<TotalcareService> totalcareServices = patientServices.getAllTotalcareService() ;
        model.addAttribute("totalcareServicesList",totalcareServices);
        return "Auth/AdminRequestView/TotalCareRequest";
    }
    @GetMapping("/accepttotalCareRequest/{id}")
    public String acceptTotalCareRequest(@PathVariable("id") Long id){
        patientServices.acceptTotalcareServiceById(id);
        return "redirect:/admin/totalCareRequest";
    }
    @GetMapping("/rejecttotalCareRequest/{id}")
    public String rejectTotalCareRequest(@PathVariable("id") Long id){
        patientServices.rejectTotalcareServiceById(id);
        return "redirect:/admin/totalCareRequest";
    }
    @GetMapping("/deletetotalCareRequest/{id}")
    public String deleteTotalCareRequest(@PathVariable("id") Long id){
        patientServices.deleteTotalcareServiceById(id);
        return "redirect:/admin/totalCareRequest";
    }
    @GetMapping("/appointmentRequest")
    public String getApplicationRequest(Model model){
        List<Appointment> appointmentList = patientServices.getAllAppointment() ;
        model.addAttribute("appointmentList",appointmentList);
        return "Auth/AdminRequestView/AppointmentRequest";
    }
    @GetMapping("/acceptAppointmentRequest/{id}")
    public String acceptApplicationRequest(@PathVariable("id") Long id){
        patientServices.acceptAppointmentById(id);
        return "redirect:/admin/appointmentRequest";
    }
    @GetMapping("/rejectAppointmentRequest/{id}")
    public String rejectApplicationRequest(@PathVariable("id") Long id){
        patientServices.rejectAppointmentById(id);
        return "redirect:/admin/appointmentRequest";
    }
    @GetMapping("/deleteAppointmentRequest/{id}")
    public String deleteApplicationRequest(@PathVariable("id") Long id){
        patientServices.deleteAppointmentById(id);
        return "redirect:/admin/appointmentRequest";
    }
    @GetMapping("/updateRole/{id}/{role}")
    public String updateUserRole(@PathVariable("id") Long id,@PathVariable("role") String role){
//        patientServices.updateUserRole(id,role);
        return "Auth/AdminDashboard";
    }
}
