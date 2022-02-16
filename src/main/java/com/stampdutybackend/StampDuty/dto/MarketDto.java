package com.stampdutybackend.StampDuty.dto;

import lombok.Data;

@Data
public class MarketDto {

    private String marketPlaceCode;

    private String marketPlaceType;

    private String totalGrosssAmount;

    private String totalStampDutyFees;

    private String vatOnExchangeFees;

    private String totalExchangeFees;

}
