package com.dio.project.stay.dto.response;

import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.dto.UserAccountDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Item} entity
 */
public record ItemResponse(Long id, String userAccountId, List<RoomResponse> rooms, String itemName, String itemGroup,
                           String itemAddr,
                           String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, float grade,
                           String infoAround, String infoBasic, String infoNotice, String infoParking,
                           String infoPeople, String infoRefund) {


    public ItemResponse of(Long id, String userAccountId, List<RoomResponse> rooms, String itemName, String itemGroup, String itemAddr, String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, float grade, String infoAround, String infoBasic, String infoNotice, String infoParking, String infoPeople, String infoRefund) {
        return new ItemResponse(id, userAccountId, rooms, itemName, itemGroup, itemAddr, itemAddrDetail, itemAddrExtra, itemEvent, imgPath, grade, infoAround, infoBasic, infoNotice, infoParking, infoPeople, infoRefund);
    }

    public static ItemResponse from(ItemDto dto) {
        return new ItemResponse(
                dto.id(),
                dto.userAccountDto().getUserId(),
                dto.rooms().stream().map(RoomResponse::from).collect(Collectors.toList()),
                dto.itemName(),
                dto.itemGroup(),
                dto.itemAddr(),
                dto.itemAddrDetail(),
                dto.itemAddrExtra(),
                dto.itemEvent(),
                dto.imgPath(),
                dto.grade(),
                dto.infoAround(),
                dto.infoBasic(),
                dto.infoNotice(),
                dto.infoParking(),
                dto.infoPeople(),
                dto.infoRefund()
        );
    }
}
