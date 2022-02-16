package com.stampdutybackend.StampDuty.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TradingClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private String totalGrossAmount;

    private String totalStampDutyFees;

    private String totalBrokerageFees;

    private String totalExchangeFees;

    private String totalCentralSecurityDepositFees;

    private String totalTradeAlertFees;

    private String totalSecFees;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "tradingMember_id", referencedColumnName = "id")
    private TradingMember tradingMember;


    @OneToMany(mappedBy = "tradingClient", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Trade> tradeList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTotalGrossAmount() {
        return totalGrossAmount;
    }

    public void setTotalGrossAmount(String totalGrossAmount) {
        this.totalGrossAmount = totalGrossAmount;
    }

    public String getTotalStampDutyFees() {
        return totalStampDutyFees;
    }

    public void setTotalStampDutyFees(String totalStampDutyFees) {
        this.totalStampDutyFees = totalStampDutyFees;
    }

    public String getTotalBrokerageFees() {
        return totalBrokerageFees;
    }

    public void setTotalBrokerageFees(String totalBrokerageFees) {
        this.totalBrokerageFees = totalBrokerageFees;
    }

    public String getTotalExchangeFees() {
        return totalExchangeFees;
    }

    public void setTotalExchangeFees(String totalExchangeFees) {
        this.totalExchangeFees = totalExchangeFees;
    }

    public String getTotalCentralSecurityDepositFees() {
        return totalCentralSecurityDepositFees;
    }

    public void setTotalCentralSecurityDepositFees(String totalCentralSecurityDepositFees) {
        this.totalCentralSecurityDepositFees = totalCentralSecurityDepositFees;
    }

    public String getTotalTradeAlertFees() {
        return totalTradeAlertFees;
    }

    public void setTotalTradeAlertFees(String totalTradeAlertFees) {
        this.totalTradeAlertFees = totalTradeAlertFees;
    }

    public String getTotalSecFees() {
        return totalSecFees;
    }

    public void setTotalSecFees(String totalSecFees) {
        this.totalSecFees = totalSecFees;
    }

    public TradingMember getTradingMember() {
        return tradingMember;
    }

    public void setTradingMember(TradingMember tradingMember) {
        this.tradingMember = tradingMember;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }
}
