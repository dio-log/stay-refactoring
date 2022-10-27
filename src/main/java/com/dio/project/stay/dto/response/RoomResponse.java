package com.dio.project.stay.dto.response;

import com.dio.project.stay.domain.type.RoomStatus;
import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.dto.RoomDto;

import java.time.LocalDateTime;

public record RoomResponse(
        Long id,
        Long itemId,
        String userId,
        String roomName,
        int roomPrice,
        String bedType,
        int bedCount,
        int roomSize,
        String viewType,
        String roomTheme,
        String roomOption,
        int basicPeople,
        int maxPeople,
        String imgPath,
        RoomStatus roomStatus,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static RoomResponse of(Long id, Long itemId,String userId, String roomName, int roomPrice, String bedType, int bedCount, int roomSize, String viewType, String roomTheme, String roomOption, int basicPeople, int maxPeople, String imgPath, RoomStatus roomStatus, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new RoomResponse(
                id,
                itemId,
                userId,
                roomName,
                roomPrice,
                bedType,
                bedCount,
                roomSize,
                viewType,
                roomTheme,
                roomOption,
                basicPeople,
                maxPeople,
                imgPath,
                roomStatus,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static RoomResponse from(RoomDto dto){
        return RoomResponse.of(
                dto.id(),
                dto.itemDto().id(),
                dto.userAccountDto().getUserId(),
                dto.roomName(),
                dto.roomPrice(),
                dto.bedType(),
                dto.bedCount(),
                dto.roomSize(),
                dto.viewType(),
                dto.roomTheme(),
                dto.roomOption(),
                dto.basicPeople(),
                dto.maxPeople(),
                dto.imgPath(),
                dto.roomStatus(),
                dto.createdAt(),
                dto.createdBy(),
                dto.modifiedAt(),
                dto.modifiedBy()
        );
    }
}
