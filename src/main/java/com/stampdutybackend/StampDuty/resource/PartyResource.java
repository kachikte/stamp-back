package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.PartyDto;
import com.stampdutybackend.StampDuty.entity.Party;
import com.stampdutybackend.StampDuty.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartyResource {

    @Autowired
    PartyService partyService;

    @GetMapping("/getParties/")
    public List<Party> getParties() {
        return  partyService.getParties();
    }

    @PostMapping("/addParty/")
    public Party addParty(@RequestBody PartyDto partyDto) {
        return partyService.addparty(partyDto);
    }
}
