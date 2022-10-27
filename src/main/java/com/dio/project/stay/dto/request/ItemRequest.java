package com.dio.project.stay.dto.request;

import com.dio.project.stay.domain.Item;
import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.dto.UserAccountDto;
import lombok.Getter;

@Getter
public class ItemRequest {
    Long id;

    String userId;
    String itemName;
    String itemGroup;
    String itemAddr;
    String itemAddrDetail;
    String itemAddrExtra;
    String itemEvent;
    String imgPath;
    float grade;
    String infoAround;
    String infoBasic;
    String infoNotice;
    String infoParking;
    String infoPeople;
    String infoRefund;

    public ItemRequest(Long id, String userId, String itemName, String itemGroup, String itemAddr, String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, float grade, String infoAround, String infoBasic, String infoNotice, String infoParking, String infoPeople, String infoRefund) {
        this.id = id;
        this.userId = userId;
        this.itemName = itemName;
        this.itemGroup = itemGroup;
        this.itemAddr = itemAddr;
        this.itemAddrDetail = itemAddrDetail;
        this.itemAddrExtra = itemAddrExtra;
        this.itemEvent = itemEvent;
        this.imgPath = imgPath;
        this.grade = grade;
        this.infoAround = infoAround;
        this.infoBasic = infoBasic;
        this.infoNotice = infoNotice;
        this.infoParking = infoParking;
        this.infoPeople = infoPeople;
        this.infoRefund = infoRefund;
    }

    public static ItemRequest of(Long id, String userId, String itemName, String itemGroup, String itemAddr, String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, float grade, String infoAround, String infoBasic, String infoNotice, String infoParking, String infoPeople, String infoRefund){
        return new ItemRequest(id, userId, itemName, itemGroup, itemAddr, itemAddrDetail, itemAddrExtra, itemEvent, imgPath, grade, infoAround, infoBasic, infoNotice, infoParking, infoPeople, infoRefund);
    }

    public ItemDto toDto(UserAccountDto userAccountDto){
        return ItemDto.of(
                id,
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
                infoRefund);
    }
}
