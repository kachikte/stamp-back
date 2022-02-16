package com.stampdutybackend.StampDuty.service;

import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.TradingMember;

import java.util.List;

public interface TradingMemberService {
    List<TradingMember> getTradingMembers();

    TradingMember addTradingMember(TradingMemberDto tradingMemberDto);
}
