package com.application.healthmanegmentsystem.Helper;

import org.springframework.stereotype.Component;

@Component
public class EmailMessage {
    public String userRegistrationMessage(String firstname){
        return "Hi "
                +firstname
                +" \n\n"
                +"Welcome to MedCare we are happy to help you for your personal health improving"
                +"\n\n"
                +"Regrads \n"
                +"medcareplatform@gmail.com";
    }
    public String userAppointmentSuccess(String firstname){
        return "Hi "
                +firstname
                +" \n\n"
                +"Your application is sent successfully. Please wait till your appointment get approved"
                +"\n\n"
                +"Regrads \n"
                +"medcareplatform@gmail.com";
    }

    public String userAmbulanceRequestSuccess(String firstName) {
        return "Hi "
                +firstName
                +" \n\n"
                +"Your application is sent successfully. Please wait till your appointment get approved"
                +"\n\n"
                +"Regrads \n"
                +"medcareplatform@gmail.com";
    }
}
