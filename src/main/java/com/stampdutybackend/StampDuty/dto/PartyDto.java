package com.stampdutybackend.StampDuty.dto;

import lombok.Data;

@Data
public class PartyDto {

    private String partyId;

    private String partyIdSource;

    private String partyRole;

    private Long tradeId;

}
