package com.dio.project.stay.dto.response;

import com.dio.project.stay.dto.UserAccountDto;

public class UserAccountResponse {

    private String userId;
    private String userPwd;
    private String email;
    private String nickname;
    private String phone;

    public UserAccountResponse(String userId, String userPwd, String email, String nickname, String phone) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
    }

    public static UserAccountResponse of(String userId, String userPwd, String email, String nickname, String phone){
        return new UserAccountResponse(
                userId,
                userPwd,
                email,
                nickname,
                phone
        );
    }

    public static UserAccountResponse from(UserAccountDto dto){
        return new UserAccountResponse(
                dto.getUserId(),
                dto.getUserPwd(),
                dto.getEmail(),
                dto.getNickname(),
                dto.getPhone()
        );
    }
}
