package com.dio.project.stay.dto;

import com.dio.project.stay.domain.Room;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Room} entity
 */
public record RoomDto(Long id, ItemDto itemDto, String roomName, int roomPrice, String bedType, int bedCount, int roomSize,
                      String viewType, String roomTheme, String roomOption, int basicPeople, int maxPeople,
                      String imgPath, String roomStatus){

    public static RoomDto of(Long id,
                   ItemDto itemDto,
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
                   String roomStatus) {
     return new RoomDto(id,
             itemDto,
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

    public static RoomDto from(Room entity) {
        return new RoomDto(
                entity.getId(),
                ItemDto.from(entity.getItem()),
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
                entity.getRoomStatus());
    }
    public Room toEntity(){
        return Room.of(
                itemDto.toEntity(),
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