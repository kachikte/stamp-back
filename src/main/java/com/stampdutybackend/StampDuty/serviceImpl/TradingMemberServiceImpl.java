package com.stampdutybackend.StampDuty.serviceImpl;

import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.Market;
import com.stampdutybackend.StampDuty.entity.TradingMember;
import com.stampdutybackend.StampDuty.repository.MarketRepository;
import com.stampdutybackend.StampDuty.repository.TradingMemberRepository;
import com.stampdutybackend.StampDuty.service.TradingMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingMemberServiceImpl implements TradingMemberService {

    @Autowired
    TradingMemberRepository tradingMemberRepository;

    @Autowired
    MarketRepository marketRepository;

    @Override
    public List<TradingMember> getTradingMembers() {
        return tradingMemberRepository.findAll();
    }

    @Override
    public TradingMember addTradingMember(TradingMemberDto tradingMemberDto) {
        TradingMember tradingMember = new TradingMember();

        Market market = marketRepository.getById(tradingMemberDto.getMarketId());

        tradingMember.setTradingMemberCode(tradingMemberDto.getTradingMemberCode());
        tradingMember.setTotalGrossAmount(tradingMemberDto.getTotalGrossAmount());
        tradingMember.setTotalBrokerageFees(tradingMemberDto.getTotalBrokerageFees());
        tradingMember.setTotalStampDutyFees(tradingMemberDto.getTotalStampDutyFees());
        tradingMember.setTotalExchangeFees(tradingMemberDto.getTotalExchangeFees());
        tradingMember.setVatOnBrokerageFees(tradingMemberDto.getVatOnBrokerageFees());
        tradingMember.setMarket(market);

        return tradingMemberRepository.save(tradingMember);
    }
}