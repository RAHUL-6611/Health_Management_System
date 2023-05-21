package com.application.healthmanegmentsystem.Repository;

import com.application.healthmanegmentsystem.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @Query("select u from UserInfo as u where u.username = ?1")
    UserInfo findByUsername(String username);

    UserInfo findUserInfoById(Long id);
}
