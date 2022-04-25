package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.TradingMember;
import com.stampdutybackend.StampDuty.service.TradingMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/getTradingMembersEx")
    public Object getTradingMembersEx(@RequestParam("marketCode") String marketCode, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getTradingMembers?marketCode=" + marketCode + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object tradingMembers = restTemplate.getForObject(url, Object.class);

        System.out.println(tradingMembers.getClass());

        return tradingMembers;
    }
}
