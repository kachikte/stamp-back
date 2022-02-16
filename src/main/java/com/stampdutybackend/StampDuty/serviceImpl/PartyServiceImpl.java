package com.stampdutybackend.StampDuty.serviceImpl;

import com.stampdutybackend.StampDuty.dto.PartyDto;
import com.stampdutybackend.StampDuty.entity.Party;
import com.stampdutybackend.StampDuty.entity.Trade;
import com.stampdutybackend.StampDuty.repository.PartyRepository;
import com.stampdutybackend.StampDuty.repository.TradeRepository;
import com.stampdutybackend.StampDuty.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Override
    public List<Party> getParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party addparty(PartyDto partyDto) {
        Trade trade = tradeRepository.getById(partyDto.getTradeId());

        Party party = new Party();

        party.setPartyId(partyDto.getPartyId());
        party.setPartyIdSource(partyDto.getPartyIdSource());
        party.setPartyRole(partyDto.getPartyRole());
        party.setTrade(trade);

        return partyRepository.save(party);
    }
}