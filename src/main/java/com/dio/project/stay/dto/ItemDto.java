package com.dio.project.stay.dto;

import com.dio.project.stay.domain.Item;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Item} entity
 */
public record ItemDto(Long id, UserAccountDto userAccountDto, List<RoomDto> rooms, String itemName, String itemGroup, String itemAddr,
                      String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, float grade,
                      String infoAround, String infoBasic, String infoNotice, String infoParking, String infoPeople,
                      String infoRefund,  LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt,
                      String modifiedBy) {
    //엔티티용
    public static ItemDto of(Long id,
                             UserAccountDto userAccountDto,
                             List<RoomDto> rooms,
                             String itemName,
                             String itemGroup,
                             String itemAddr,
                             String itemAddrDetail,
                             String itemAddrExtra,
                             String itemEvent,
                             String imgPath,
                             float grade,
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
        return new ItemDto(id,
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

    //생성용

    //생성시엔 id null, 업뎃은 id 있겠지
    public static ItemDto of(
            Long id,
            UserAccountDto userAccountDto,
            String itemName,
            String itemGroup,
            String itemAddr,
            String itemAddrDetail,
            String itemAddrExtra,
            String itemEvent,
            String imgPath,
            float grade,
            String infoAround,
            String infoBasic,
            String infoNotice,
            String infoParking,
            String infoPeople,
            String infoRefund
    ) {
        return new ItemDto(id,
                userAccountDto,
                null,
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
                null,
                null,
                null,
                null
        );
    }

    public static ItemDto from(Item entity) {
        return new ItemDto(entity.getId(),
                //매개변수 엔티티객체로부터 어카운트 엔티티객체 받고
                UserAccountDto.from(entity.getUserAccount()),
                entity.getRooms().stream()
                        .map(RoomDto::from)
                        .collect(Collectors.toList()),
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
                entity.getModifiedBy());
    }

    public Item toEntity(){
        return Item.of(
                userAccountDto.toEntity(),
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
                infoRefund
        );
    }
}