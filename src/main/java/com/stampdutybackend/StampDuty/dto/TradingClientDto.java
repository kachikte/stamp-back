package com.stampdutybackend.StampDuty.dto;

import lombok.Data;

@Data
public class TradingClientDto {

    private String accountNumber;

    private String totalGrossAmount;

    private String totalStampDutyFees;

    private String totalBrokerageFees;

    private String totalExchangeFees;

    private String totalCentralSecurityDepositFees;

    private String totalTradeAlertFees;

    private String totalSecFees;

    private Long tradingMemberId;

}
