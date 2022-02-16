package com.stampdutybackend.StampDuty.dto;

import lombok.Data;

@Data
public class TradeDto {

    private String executionId;

    private String securityCode;

    private String securityType;

    private String marketSegmentId;

    private String quantity;

    private String price;

    private String transactionTime;

    private String settlementDate;

    private int numberOfSide;

    private String grossTradeAmount;

    private String side;

    private String orderId;

    private String clientOrderId;

    private String accountNumber;

    private Long tradingClientId;

}
