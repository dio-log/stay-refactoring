package com.dio.project.stay.dto;

import com.dio.project.stay.domain.UserAccount;
import com.dio.project.stay.domain.type.UserStatus;
import com.dio.project.stay.domain.type.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.dio.project.stay.domain.UserAccount} entity
 */

@Setter
@Getter
public class UserAccountDto {
    private String userId;
    private String userPwd;
    private String email;
    private String nickname;
    private String phone;

    private UserStatus userStatus;

    private UserType userType;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public UserAccountDto(String userId, String userPwd, String email, String nickname, String phone,UserType userType, UserStatus userStatus, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.userType = userType;
        this.userStatus = userStatus;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }


    public static UserAccountDto of(String userId, String userPwd, String email, String nickname, String phone, UserType userType, UserStatus userStatus, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(
                userId,
                userPwd,
                email,
                nickname,
                phone,
                userType,
                userStatus,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static UserAccountDto of(String userId, String userPwd, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        return new UserAccountDto(
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

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPwd(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPhone(),
                entity.getUserType(),
                entity.getUserStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
    public UserAccount toEntity(){
        return UserAccount.of(
                userId,
                userPwd,
                email,
                nickname,
                phone,
                userType,
                userStatus
        );
    }
}
