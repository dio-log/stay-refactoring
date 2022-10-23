package com.dio.project.stay.dto;

import com.dio.project.stay.domain.Item;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Item} entity
 */
public record ItemDto(Long id, UserAccountDto userAccountDto, String itemName, String itemGroup, String itemAddr,
                      String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, String grade,
                      String infoAround, String infoBasic, String infoNotice, String infoParking, String infoPeople,
                      String infoRefund, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt,
                      String modifiedBy) {

    public static ItemDto of(Long id,
                             UserAccountDto userAccountDto,
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
        return new ItemDto(id,
                userAccountDto,
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

    public static ItemDto from(Item entity) {
        return new ItemDto(entity.getId(),
                //매개변수 엔티티객체로부터 어카운트 엔티티객체 받고
                UserAccountDto.from(entity.getUserAccount()),
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
                infoRefund,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }
}