package com.stampdutybackend.StampDuty.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marketPlaceCode;

    private String marketPlaceType;

    private String totalGrosssAmount;

    private String totalStampDutyFees;

    private String vatOnExchangeFees;

    private String totalExchangeFees;

    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TradingMember> tradingMemberList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMarketPlaceCode() {
        return marketPlaceCode;
    }

    public void setMarketPlaceCode(String marketPlaceCode) {
        this.marketPlaceCode = marketPlaceCode;
    }

    public String getMarketPlaceType() {
        return marketPlaceType;
    }

    public void setMarketPlaceType(String marketPlaceType) {
        this.marketPlaceType = marketPlaceType;
    }

    public String getTotalGrosssAmount() {
        return totalGrosssAmount;
    }

    public void setTotalGrosssAmount(String totalGrosssAmount) {
        this.totalGrosssAmount = totalGrosssAmount;
    }

    public String getTotalStampDutyFees() {
        return totalStampDutyFees;
    }

    public void setTotalStampDutyFees(String totalStampDutyFees) {
        this.totalStampDutyFees = totalStampDutyFees;
    }

    public String getVatOnExchangeFees() {
        return vatOnExchangeFees;
    }

    public void setVatOnExchangeFees(String vatOnExchangeFees) {
        this.vatOnExchangeFees = vatOnExchangeFees;
    }

    public String getTotalExchangeFees() {
        return totalExchangeFees;
    }

    public void setTotalExchangeFees(String totalExchangeFees) {
        this.totalExchangeFees = totalExchangeFees;
    }

    public List<TradingMember> getTradingMemberList() {
        return tradingMemberList;
    }

    public void setTradingMemberList(List<TradingMember> tradingMemberList) {
        this.tradingMemberList = tradingMemberList;
    }
}
