package com.stampduty.Stamp.Duty.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StampDutyResource {

    @GetMapping("/getTradingMembersEx")
    public Object getTradingMembersEx(@RequestParam("marketCode") String marketCode, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getTradingMembers?marketCode=" + marketCode + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object tradingMembers = restTemplate.getForObject(url, Object.class);

        System.out.println(tradingMembers.getClass());

        return tradingMembers;
    }

    @GetMapping("/getStakeHolderProfile/")
    public Object getStakeHolderProfile(@RequestParam("emailAddress") String emailAddress, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getStakeHolderProfile?emailAddress=" + emailAddress + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object stakeHolderProfile = restTemplate.getForObject(url, Object.class);

        return stakeHolderProfile;
    }

    @GetMapping("/getContractNotesTaxable/")
    public Object getContractNotesTaxable(@RequestParam("emailAddress") String emailAddress, @RequestParam("requesterCode") String requesterCode, @RequestParam("marketCode") String marketCode, @RequestParam("monthAndYear") String monthAndYear, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getContractNotesTaxable?emailAddress=" + emailAddress + "&requesterCode=" + requesterCode + "&marketCode=" + marketCode + "&monthAndYear=" + monthAndYear + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object contractNotesTaxable = restTemplate.getForObject(url, Object.class);

        return contractNotesTaxable;
    }

}
