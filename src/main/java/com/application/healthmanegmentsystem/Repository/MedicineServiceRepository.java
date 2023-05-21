package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.MedicineService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineServiceRepository extends JpaRepository<MedicineService,Long> {
    MedicineService findMedicineServiceById(Long id);

    Long deleteMedicineServiceById(Long id);

    @Query(value = "select distinct a.medicine_service from medicine_service as a where a.medicine_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
