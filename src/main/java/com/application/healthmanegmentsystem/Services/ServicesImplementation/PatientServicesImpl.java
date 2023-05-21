package com.application.healthmanegmentsystem.Services.ServicesImplementation;

import com.application.healthmanegmentsystem.Entity.*;
import com.application.healthmanegmentsystem.Helper.EmailMessage;
import com.application.healthmanegmentsystem.Repository.*;
import com.application.healthmanegmentsystem.Services.EmailSenderService;
import com.application.healthmanegmentsystem.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class PatientServicesImpl implements PatientServices {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    AmbulanceServiceRepository ambulanceServiceRepository;
    @Autowired
    BedFacilityServiceRepository bedFacilityServiceRepository;
    @Autowired
    FreeCheckupServiceRepository freeCheckupServiceRepository;
    @Autowired
    MedicineServiceRepository medicineServiceRepository;
    @Autowired
    TotalCareServiceRepository totalCareServiceRepository;
    @Autowired
    EmailSenderService sendEmail;
    @Autowired
    EmailMessage emailMessage;
    @Override
    public String processRegistration(UserInfo userInfo) {
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(new Role("USER"));
//        userInfo.setRoles(roleSet);
        String[] name = userInfo.getFirstName().split(" ",2);
        userInfo.setFirstName(name[0]);
        userInfo.setLastName(name.length == 2 ? name[1]:"");
        userInfo.setEnabled(true);
        Role role = new Role("ADMIN");
        userInfo.setRoles(role);
        userInfoRepository.save(userInfo);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userRegistrationMessage(userInfo.getFirstName()),
                "MedCare Account Created");
        return "Saved";
    }

    @Override
    public List<UserInfo> getAllUser() {
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        for(UserInfo i : userInfoList){
            i.setRole(i.getRoles().getName());
        }
        return userInfoList;
    }

    @Override
    public UserInfo getLogedInUserDetailss(String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        System.out.println(userInfo.getAppointmentList());
        return userInfo;
    }

    @Override
    public List<Appointment> getAllAppointment() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    @Override
    public List<AmbulanceService> getAllAmbulanceService() {
        List<AmbulanceService> ambulanceServices = ambulanceServiceRepository.findAll();
        return ambulanceServices;
    }

    @Override
    public List<BedFacilityService> getAllBedFacilityService() {
        List<BedFacilityService> bedFacilityServices = bedFacilityServiceRepository.findAll();
        return bedFacilityServices;
    }

    @Override
    public List<FreeCheckupService> getAllFreeCheckupService() {
        List<FreeCheckupService> freeCheckupServices = freeCheckupServiceRepository.findAll();
        return freeCheckupServices;
    }

    @Override
    public List<MedicineService> getAllMedicineService() {
        List<MedicineService> medicineServices = medicineServiceRepository.findAll();
        return medicineServices;
    }

    @Override
    public List<TotalcareService> getAllTotalcareService() {
        List<TotalcareService> totalcareServices = totalCareServiceRepository.findAll();
        return totalcareServices;
    }

    @Override
    public void updateProfile(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void saveAppoinment(Appointment appointment,String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<Appointment> appointmentSet = userinfo.getAppointmentList().size() >0 ? userinfo.getAppointmentList(): new HashSet<>();
        appointment.setStatus(false);
        appointmentSet.add(appointment);
        userinfo.setAppointmentList(appointmentSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAppointmentSuccess(userinfo.getFirstName()),
                "MedCare Appointment Successfully submitted");
    }

    @Override
    public void saveAmbulanceService(AmbulanceService ambulanceService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<AmbulanceService> ambulanceServiceSet = userinfo.getAmbulanceServiceList().size()>0 ? userinfo.getAmbulanceServiceList() : new HashSet<>();
        ambulanceService.setStatus(false);
        ambulanceServiceSet.add(ambulanceService);
        userinfo.setAmbulanceServiceList(ambulanceServiceSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userinfo.getFirstName()),
                "MedCare Ambulance Request Successfully submitted");
    }

    @Override
    public void saveBedFacilityService(BedFacilityService bedFacilityService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<BedFacilityService> bedFacilityServiceSet = userinfo.getBedFacilityServiceList().size() > 0 ? userinfo.getBedFacilityServiceList() : new HashSet<>();
        bedFacilityService.setStatus(false);
        bedFacilityServiceSet.add(bedFacilityService);
        userinfo.setBedFacilityServiceList(bedFacilityServiceSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userinfo.getFirstName()),
                "MedCare BedFacility Request Successfully submitted");
    }

    @Override
    public void saveFreeCheckupService(FreeCheckupService freeCheckupService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<FreeCheckupService> freeCheckupServiceSet = userinfo.getFreeCheckupServiceList().size() > 0 ?  userinfo.getFreeCheckupServiceList() : new HashSet<>();
        freeCheckupService.setStatus(false);
        freeCheckupServiceSet.add(freeCheckupService);
        userinfo.setFreeCheckupServiceList(freeCheckupServiceSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userinfo.getFirstName()),
                "MedCare FreeCheckup Request Successfully submitted");
    }

    @Override
    public void saveMedicineService(MedicineService medicineService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<MedicineService> medicineServiceSet = userinfo.getMedicineServicesList().size() > 0 ? userinfo.getMedicineServicesList(): new HashSet<>();
        medicineService.setStatus(false);
        medicineServiceSet.add(medicineService);
        userinfo.setMedicineServicesList(medicineServiceSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userinfo.getFirstName()),
                "MedCare Medicine Request Successfully submitted");
    }

    @Override
    public void saveTotalcareService(TotalcareService totalcareService, String username) {
        UserInfo userinfo = userInfoRepository.findByUsername(username);
        Set<TotalcareService> totalcareServiceSet = userinfo.getTotalcareServicesList().size()>0 ? userinfo.getTotalcareServicesList() : new HashSet<>();
        totalcareService.setStatus(false);
        totalcareServiceSet.add(totalcareService);
        userinfo.setTotalcareServicesList(totalcareServiceSet);
        userInfoRepository.save(userinfo);
        boolean status = sendEmail.sendSimpleMail(userinfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userinfo.getFirstName()),
                "MedCare TotalCare Request Successfully submitted");
    }

    @Override
    public void acceptAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        UserInfo userInfo = userInfoRepository.findUserInfoById(appointmentRepository.getUserId(id));
        appointment.setStatus(true);
        appointmentRepository.save(appointment);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare Appointment Request Accepted");
    }

    @Override
    public void rejectAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        appointment.setStatus(false);
        appointmentRepository.save(appointment);

    }

    @Override
    public void deleteAppointmentById(Long id) {
        Long deletedCount = appointmentRepository.deleteAppointmentById(id);
    }

    @Override
    public void acceptBedFacilityServiceById(Long id) {
        BedFacilityService bedFacilityService = bedFacilityServiceRepository.findBedFacilityServiceById(id);
        System.out.println(bedFacilityServiceRepository.getUserId(id));
        UserInfo userInfo = userInfoRepository.findUserInfoById(bedFacilityServiceRepository.getUserId(id));
        bedFacilityService.setStatus(true);
        bedFacilityServiceRepository.save(bedFacilityService);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare BedFacility Request Accepted");
    }

    @Override
    public void rejectBedFacilityServiceById(Long id) {
        BedFacilityService bedFacilityService = bedFacilityServiceRepository.findBedFacilityServiceById(id);
        bedFacilityService.setStatus(false);
        bedFacilityServiceRepository.save(bedFacilityService);
    }

    @Override
    public void deleteBedFacilityServiceById(Long id) {
        Long deletedCount =bedFacilityServiceRepository.deleteBedFacilityServiceById(id);
    }

    @Override
    public void acceptAmbulanceServiceById(Long id) {
        AmbulanceService ambulanceService = ambulanceServiceRepository.findAmbulanceServiceById(id);
        UserInfo userInfo = userInfoRepository.findUserInfoById(ambulanceServiceRepository.getUserId(id));
        ambulanceService.setStatus(true);
        ambulanceServiceRepository.save(ambulanceService);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare Amulance Request Accepted");
    }

    @Override
    public void rejectAmbulanceServiceById(Long id) {
        AmbulanceService ambulanceService = ambulanceServiceRepository.findAmbulanceServiceById(id);
        ambulanceService.setStatus(false);
        ambulanceServiceRepository.save(ambulanceService);
    }

    @Override
    public void deleteAmbulanceServiceById(Long id) {
        Long deletedCount =ambulanceServiceRepository.deleteAmbulanceServiceById(id);
    }

    @Override
    public void acceptFreeCheckupServiceById(Long id) {
        FreeCheckupService freeCheckupService = freeCheckupServiceRepository.findFreeCheckupServiceById(id);
        UserInfo userInfo = userInfoRepository.findUserInfoById(freeCheckupServiceRepository.getUserId(id));
        freeCheckupService.setStatus(true);
        freeCheckupServiceRepository.save(freeCheckupService);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare FreeCheckup Request Accepted");
    }

    @Override
    public void rejectFreeCheckupServiceById(Long id) {
        FreeCheckupService freeCheckupService = freeCheckupServiceRepository.findFreeCheckupServiceById(id);
        freeCheckupService.setStatus(false);
        freeCheckupServiceRepository.save(freeCheckupService);
    }

    @Override
    public void deleteFreeCheckupServiceById(Long id) {
        Long deletedCount = freeCheckupServiceRepository.deleteFreeCheckupServiceById(id);
    }

    @Override
    public void acceptMedicineServiceById(Long id) {
        MedicineService medicineService = medicineServiceRepository.findMedicineServiceById(id);
        UserInfo userInfo = userInfoRepository.findUserInfoById(medicineServiceRepository.getUserId(id));
        medicineService.setStatus(true);
        medicineServiceRepository.save(medicineService);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare Medicine Request Accepted");
    }

    @Override
    public void rejectMedicineServiceById(Long id) {
        MedicineService medicineService = medicineServiceRepository.findMedicineServiceById(id);
        medicineService.setStatus(true);
        medicineServiceRepository.save(medicineService);
    }

    @Override
    public void deleteMedicineServiceById(Long id) {
        Long deletedCount = medicineServiceRepository.deleteMedicineServiceById(id);
    }

    @Override
    public void acceptTotalcareServiceById(Long id) {
        TotalcareService totalcareService = totalCareServiceRepository.findTotalcareServiceById(id);
        UserInfo userInfo = userInfoRepository.findUserInfoById(totalCareServiceRepository.getUserId(id));
        totalcareService.setStatus(true);
        totalCareServiceRepository.save(totalcareService);
        boolean status = sendEmail.sendSimpleMail(userInfo.getUsername(),
                emailMessage.userAmbulanceRequestSuccess(userInfo.getFirstName()),
                "MedCare TotalCare Request Accepted");
    }

    @Override
    public void rejectTotalcareServiceById(Long id) {
        TotalcareService totalcareService = totalCareServiceRepository.findTotalcareServiceById(id);
        totalcareService.setStatus(false);
        totalCareServiceRepository.save(totalcareService);
    }

    @Override
    public void deleteTotalcareServiceById(Long id) {
        Long deletedCount =totalCareServiceRepository.deleteTotalcareServiceById(id);
    }
}
