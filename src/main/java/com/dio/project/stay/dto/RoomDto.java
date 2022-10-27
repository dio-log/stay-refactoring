package com.dio.project.stay.dto;

import com.dio.project.stay.domain.Item;
import com.dio.project.stay.domain.Room;
import com.dio.project.stay.domain.type.RoomStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Room} entity
 */
public record RoomDto(Long id, Long itemId, UserAccountDto userAccountDto, String roomName, int roomPrice, String bedType, int bedCount,
                      int roomSize,
                      String viewType, String roomTheme, String roomOption, int basicPeople, int maxPeople,
                      String imgPath, RoomStatus roomStatus, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {

    public static RoomDto of(Long id,
                             Long itemId,
                             UserAccountDto userAccountDto,
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
        return new RoomDto(id,
                itemId,
                userAccountDto,
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

    public static RoomDto of(
                             Long itemId,
                             UserAccountDto userAccountDto,
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
                             RoomStatus roomStatus) {
        return new RoomDto(null,
                itemId,
                userAccountDto,
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
                null,
                null,
                null,
                null);
    }

    public static RoomDto from(Room entity) {
        return new RoomDto(
                entity.getId(),
                entity.getItem().getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getRoomName(),
                entity.getRoomPrice(),
                entity.getBedType(),
                entity.getBedCount(),
                entity.getRoomSize(),
                entity.getViewType(),
                entity.getRoomTheme(),
                entity.getRoomOption(),
                entity.getBasicPeople(),
                entity.getMaxPeople(),
                entity.getImgPath(),
                entity.getRoomStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy());
    }

    public Room toEntity(Item item) {
        return Room.of(
                item,
                userAccountDto.toEntity(),
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
                roomStatus);
    }
}