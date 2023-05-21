package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.BedFacilityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BedFacilityServiceRepository extends JpaRepository<BedFacilityService,Long> {
    BedFacilityService findBedFacilityServiceById(Long id);

    Long deleteBedFacilityServiceById(Long id);

    @Query(value = "select distinct a.bed_facility_service from bed_facility_service as a where a.bed_facility_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
