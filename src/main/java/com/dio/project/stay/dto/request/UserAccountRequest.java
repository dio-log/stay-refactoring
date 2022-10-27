package com.dio.project.stay.dto.request;

import com.dio.project.stay.domain.type.UserStatus;
import com.dio.project.stay.domain.type.UserType;
import com.dio.project.stay.dto.UserAccountDto;

public class UserAccountRequest{
    private String userId;
    private String userPwd;
    private String email;
    private String nickname;
    private String phone;

    private UserType userType;

    private UserStatus userStatus;

    public UserAccountRequest(String userId, String userPwd, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.userType = userType;
        this.userStatus = userStatus;
    }

    public UserAccountDto toDto(){
        return UserAccountDto.of(
                userId,
                userPwd,
                email,
                nickname,
                phone,
                userType,
                userStatus,
                null,
                null,
                null,
                null
        );
    }
}