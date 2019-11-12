package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Collection;

public class MyUserPrincipal implements UserDetails {
    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getRole() == RoleEnum.ROLE_ADMIN.getNum()) {
            return AuthorityUtils.createAuthorityList(RoleEnum.ROLE_ADMIN.getName());
        }
        return AuthorityUtils.createAuthorityList(RoleEnum.ROLE_USER.getName());
    }

    @Override
    public String getPassword() {
        String cryptPwd = new BCryptPasswordEncoder().encode(user.getPwd());
        return cryptPwd;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
        return true;
    }
}