package com.application.healthmanegmentsystem.Services;

import com.application.healthmanegmentsystem.Entity.*;

import java.util.List;
import java.util.Set;

public interface PatientServices {
    String processRegistration(UserInfo userPatient);
    List<UserInfo> getAllUser();
    UserInfo getLogedInUserDetailss(String Username);

    List<Appointment> getAllAppointment();
    List<AmbulanceService> getAllAmbulanceService();
    List<BedFacilityService> getAllBedFacilityService();
    List<FreeCheckupService> getAllFreeCheckupService();
    List<MedicineService> getAllMedicineService();
    List<TotalcareService> getAllTotalcareService();
    void updateProfile(UserInfo userInfo);

    void saveAppoinment(Appointment appointment,String username);
    void saveAmbulanceService(AmbulanceService ambulanceService, String username);
    void saveBedFacilityService(BedFacilityService bedFacilityService, String username);
    void saveFreeCheckupService(FreeCheckupService freeCheckupService, String username);
    void saveMedicineService(MedicineService medicineService,String username);
    void saveTotalcareService(TotalcareService totalcareService,String username);


    void acceptAppointmentById(Long id);
    void rejectAppointmentById(Long id);
    void deleteAppointmentById(Long id);
    void acceptBedFacilityServiceById(Long id);
    void rejectBedFacilityServiceById(Long id);
    void deleteBedFacilityServiceById(Long id);
    void acceptAmbulanceServiceById(Long id);
    void rejectAmbulanceServiceById(Long id);
    void deleteAmbulanceServiceById(Long id);

    void acceptFreeCheckupServiceById(Long id);
    void rejectFreeCheckupServiceById(Long id);
    void deleteFreeCheckupServiceById(Long id);

    void acceptMedicineServiceById(Long id);
    void rejectMedicineServiceById(Long id);
    void deleteMedicineServiceById(Long id);

    void acceptTotalcareServiceById(Long id);
    void rejectTotalcareServiceById(Long id);
    void deleteTotalcareServiceById(Long id);


}
