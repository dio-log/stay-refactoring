package com.dio.project.stay.dto;

import com.dio.project.stay.domain.Item;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Item} entity
 */
public record ItemWithRoomsDto(Long id, UserAccountDto userAccountDto, List<RoomDto> rooms, String itemName,
                               String itemGroup, String itemAddr, String itemAddrDetail, String itemAddrExtra,
                               String itemEvent, String imgPath, String grade, String infoAround, String infoBasic,
                               String infoNotice, String infoParking, String infoPeople, String infoRefund,
                               LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt,
                               String modifiedBy) {

    public static ItemWithRoomsDto of(Long id,
                            UserAccountDto userAccountDto,
                            List<RoomDto> rooms,
                            String itemName,
                            String itemGroup,
                            String itemAddr,
                            String itemAddrDetail,
                            String itemAddrExtra,
                            String itemEvent,
                            String imgPath,
                            String grade,
                            String infoAround,
                            String infoBasic,
                            String infoNotice,
                            String infoParking,
                            String infoPeople,
                            String infoRefund,
                            LocalDateTime createdAt,
                            String createdBy,
                            LocalDateTime modifiedAt,
                            String modifiedBy) {
       return new ItemWithRoomsDto(id,
               userAccountDto,
               rooms,
               itemName,
               itemGroup,
               itemAddr,
               itemAddrDetail,
               itemAddrExtra,
               itemEvent,
               imgPath,
               grade,
               infoAround,
               infoBasic,
               infoNotice,
               infoParking,
               infoPeople,
               infoRefund,
               createdAt,
               createdBy,
               modifiedAt,
               modifiedBy);
    }

    public ItemWithRoomsDto from(Item entity){
        return new ItemWithRoomsDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getRooms().stream().map(RoomDto::from).collect(Collectors.toList()),
                entity.getItemName(),
                entity.getItemGroup(),
                entity.getItemAddr(),
                entity.getItemAddrDetail(),
                entity.getItemAddrExtra(),
                entity.getItemEvent(),
                entity.getImgPath(),
                entity.getGrade(),
                entity.getInfoAround(),
                entity.getInfoBasic(),
                entity.getInfoNotice(),
                entity.getInfoParking(),
                entity.getInfoPeople(),
                entity.getInfoRefund(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
}