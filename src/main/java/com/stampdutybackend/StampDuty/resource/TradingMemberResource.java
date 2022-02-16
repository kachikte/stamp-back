package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.TradingMember;
import com.stampdutybackend.StampDuty.service.TradingMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradingMemberResource {

    @Autowired
    TradingMemberService tradingMemberService;

    @GetMapping("/getTradingMembers/")
    public List<TradingMember> getTradingMembers() {
        return tradingMemberService.getTradingMembers();
    }

    @PostMapping("/addTradingMember/")
    public TradingMember addTradingMembers(@RequestBody TradingMemberDto tradingMemberDto) {
        return tradingMemberService.addTradingMember(tradingMemberDto);
    }
}
