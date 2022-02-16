package com.stampdutybackend.StampDuty.service;

import com.stampdutybackend.StampDuty.dto.PartyDto;
import com.stampdutybackend.StampDuty.entity.Party;

import java.util.List;

public interface PartyService {

    List<Party> getParties();

    Party addparty(PartyDto partyDto);
}
