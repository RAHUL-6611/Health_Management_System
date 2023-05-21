package com.application.healthmanegmentsystem.Data;

import com.application.healthmanegmentsystem.Entity.Role;
import com.application.healthmanegmentsystem.Entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private UserInfo userInfo;

    public UserDetailsImpl(UserInfo userinfo) {
        this.userInfo = userinfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Role> roles = userInfo.getRoles();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        Role role = userInfo.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userInfo.getEnabled();
    }
}
