package com.stampdutybackend.StampDuty.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TradingMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradingMemberCode;

    private String totalGrossAmount;

    private String totalStampDutyFees;

    private String totalBrokerageFees;

    private String totalExchangeFees;

    private String vatOnBrokerageFees;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "market_id", referencedColumnName = "id")
    @JsonBackReference
    private Market market;


    @OneToMany(mappedBy = "tradingMember", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TradingClient> tradingClientList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTradingMemberCode() {
        return tradingMemberCode;
    }

    public void setTradingMemberCode(String tradingMemberCode) {
        this.tradingMemberCode = tradingMemberCode;
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

    public String getVatOnBrokerageFees() {
        return vatOnBrokerageFees;
    }

    public void setVatOnBrokerageFees(String vatOnBrokerageFees) {
        this.vatOnBrokerageFees = vatOnBrokerageFees;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<TradingClient> getTradingClientList() {
        return tradingClientList;
    }

    public void setTradingClientList(List<TradingClient> tradingClientList) {
        this.tradingClientList = tradingClientList;
    }
}
