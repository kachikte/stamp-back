package com.stampdutybackend.StampDuty.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "tradingClient_id", referencedColumnName = "id")
    private TradingClient tradingClient;

    @OneToMany(mappedBy = "trade", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Party> partyList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getMarketSegmentId() {
        return marketSegmentId;
    }

    public void setMarketSegmentId(String marketSegmentId) {
        this.marketSegmentId = marketSegmentId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public int getNumberOfSide() {
        return numberOfSide;
    }

    public void setNumberOfSide(int numberOfSide) {
        this.numberOfSide = numberOfSide;
    }

    public String getGrossTradeAmount() {
        return grossTradeAmount;
    }

    public void setGrossTradeAmount(String grossTradeAmount) {
        this.grossTradeAmount = grossTradeAmount;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TradingClient getTradingClient() {
        return tradingClient;
    }

    public void setTradingClient(TradingClient tradingClient) {
        this.tradingClient = tradingClient;
    }

    public List<Party> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<Party> partyList) {
        this.partyList = partyList;
    }
}
