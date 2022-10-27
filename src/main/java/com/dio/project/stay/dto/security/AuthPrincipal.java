package com.dio.project.stay.dto.security;

import com.dio.project.stay.domain.type.UserStatus;
import com.dio.project.stay.domain.type.UserType;
import com.dio.project.stay.dto.UserAccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AuthPrincipal implements UserDetails {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String phone;

    private UserType userType;

    //UserStatus클래스를 인증수단으로 활용
    private Collection<? extends GrantedAuthority> authorities;

    public AuthPrincipal(String username, String password, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.userType = userType;
        this.authorities = Collections.singleton(new SimpleGrantedAuthority(userStatus.getDescription()));
    }

    public static AuthPrincipal of(String username, String password, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        return new AuthPrincipal(
                username,
                password,
                email,
                nickname,
                phone,
                userType,
                userStatus);
    }

    public static AuthPrincipal from(UserAccountDto userAccountDto){
        return AuthPrincipal.of(
                userAccountDto.getUserId(),
                userAccountDto.getUserPwd(),
                userAccountDto.getEmail(),
                userAccountDto.getNickname(),
                userAccountDto.getPhone(),
                userAccountDto.getUserType(),
                userAccountDto.getUserStatus()
        );
    }

    public UserAccountDto toUserAccountDto(){
        return UserAccountDto.of(
                username,
                password,
                email,
                nickname,
                phone,
                userType,
                toUserStatus(authorities.stream().map(grantedAuthority -> getAuthorities()).toString()),
                null,
                null,
                null,
                null
                );
    }

    private UserStatus toUserStatus(String description){
        UserStatus userStatus = null;
        if(description.equals("활성화 계정")){
            userStatus = UserStatus.ACTIVATION;
        }else if(description.equals("삭제 계정")){
            userStatus = UserStatus.DEACTIVATION;
        }else if(description.equals("휴면 계정")){
            userStatus = UserStatus.DORMANT;
        }
        return userStatus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
