package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Role,Long> {
}
