package com.dio.project.stay.dto.request;

import com.dio.project.stay.domain.UserAccount;
import com.dio.project.stay.domain.type.RoomStatus;
import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.dto.RoomDto;
import com.dio.project.stay.dto.UserAccountDto;

public record RoomRequest(
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
        RoomStatus roomStatus
) {

    public static RoomRequest of(Long id, Long itemId, String userId, String roomName, int roomPrice, String bedType, int bedCount, int roomSize, String viewType, String roomTheme, String roomOption, int basicPeople, int maxPeople, String imgPath, RoomStatus roomStatus) {
        return new RoomRequest(
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
          roomStatus
        );
    }
    public RoomDto toDto(UserAccountDto userAccountDto){
        return RoomDto.of(
                null,
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
                roomStatus);
    }




}
