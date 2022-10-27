package com.dio.project.stay.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    ADMIN("관리자"), INDIVIDUAL("개인"), ENTERPRISE("사업자");

    private String desrciption;

}
