package com.application.healthmanegmentsystem.Data;

import com.application.healthmanegmentsystem.Entity.UserInfo;
import com.application.healthmanegmentsystem.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoRepository userPatientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =  userPatientRepository.findByUsername(username);
        if(userInfo == null ){
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetailsImpl(userInfo);
    }
}
