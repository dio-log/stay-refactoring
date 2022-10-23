package com.dio.project.stay.dto.response;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dio.project.stay.domain.Item} entity
 */
public record ItemResponse(Long id, Long userAccountId, String itemName, String itemGroup, String itemAddr,
                           String itemAddrDetail, String itemAddrExtra, String itemEvent, String imgPath, String grade,
                           String infoAround, String infoBasic, String infoNotice, String infoParking,
                           String infoPeople, String infoRefund) implements Serializable {
}