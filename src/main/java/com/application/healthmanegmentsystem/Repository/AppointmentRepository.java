package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("select a from Appointment as a where a.id = ?1")
    Appointment findAppointmentById(Long id);

    Long deleteAppointmentById(Long id);

//    @Native("select user_appointments from appointments as a where a.id == ?1")
    @Query(value = "select distinct a.user_appointments from appointments as a where a.appointment_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
