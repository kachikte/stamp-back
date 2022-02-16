package com.stampdutybackend.StampDuty.dto;

import lombok.Data;

@Data
public class TradingMemberDto {

    private String tradingMemberCode;

    private String totalGrossAmount;

    private String totalStampDutyFees;

    private String totalBrokerageFees;

    private String totalExchangeFees;

    private String vatOnBrokerageFees;

    private Long marketId;

}
