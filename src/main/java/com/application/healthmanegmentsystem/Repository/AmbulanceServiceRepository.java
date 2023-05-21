package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.AmbulanceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceServiceRepository extends JpaRepository<AmbulanceService,Long> {
    AmbulanceService findAmbulanceServiceById(Long id);

    Long deleteAmbulanceServiceById(Long id);

    @Query(value = "select distinct a.ambulance_service from ambulance_service as a where a.aumbulance_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
