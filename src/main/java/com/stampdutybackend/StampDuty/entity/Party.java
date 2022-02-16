package com.stampdutybackend.StampDuty.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partyId;

    private String partyIdSource;

    private String partyRole;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "trade_id", referencedColumnName = "id")
    private Trade trade;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyIdSource() {
        return partyIdSource;
    }

    public void setPartyIdSource(String partyIdSource) {
        this.partyIdSource = partyIdSource;
    }

    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(String partyRole) {
        this.partyRole = partyRole;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }
}
