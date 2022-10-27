package com.dio.project.stay.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVATION("활성화 계정"), DEACTIVATION("삭제 계정"), DORMANT("휴면 계정");

    private String description;


}
