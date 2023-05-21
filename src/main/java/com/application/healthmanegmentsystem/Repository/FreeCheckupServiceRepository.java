package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.FreeCheckupService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCheckupServiceRepository extends JpaRepository<FreeCheckupService,Long> {
    FreeCheckupService findFreeCheckupServiceById(Long id);

    Long deleteFreeCheckupServiceById(Long id);

    @Query(value = "select distinct a.free_checkup_service from free_checkup_service as a where a.free_checkup_id = ?1",nativeQuery = true)
    Long getUserId(Long id);
}
