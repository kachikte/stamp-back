package com.stampdutybackend.StampDuty.resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource {

    @GetMapping("/getStakeHolderProfile/")
    public Object getStakeHolderProfile(@RequestParam("emailAddress") String emailAddress, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getStakeHolderProfile?emailAddress=" + emailAddress + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object stakeHolderProfile = restTemplate.getForObject(url, Object.class);

        return stakeHolderProfile;
    }
}
