package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.TotalcareService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCareServiceRepository extends JpaRepository<TotalcareService,Long> {
    TotalcareService findTotalcareServiceById(Long id);
    Long deleteTotalcareServiceById(Long id);
    @Query(value = "select distinct a.totalcare_service from totalcare_service as a where a.total_care_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
