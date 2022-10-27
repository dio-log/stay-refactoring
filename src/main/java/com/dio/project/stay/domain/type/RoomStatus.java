package com.dio.project.stay.domain.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoomStatus {
    ACTIVAION("활성화"), DEACTIVATION("비활성화");

    private String description;
}
