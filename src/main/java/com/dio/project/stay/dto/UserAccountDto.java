package com.dio.project.stay.dto;

import com.dio.project.stay.domain.UserAccount;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.dio.project.stay.domain.UserAccount} entity
 */
public record UserAccountDto(Long id, String userId, String userPwd, String email, String nickname, String phone,
                             LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt,
                             String modifiedBy) implements Serializable {


    public static UserAccountDto of(Long id, String userId, String userPwd, String email, String nickname, String phone, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(id,
                userId,
                userPwd,
                email,
                nickname,
                phone,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUserPwd(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPhone(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy());
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPwd,
                email,
                nickname,
                phone
        );
    }


}