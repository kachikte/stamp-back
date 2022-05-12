package com.stampduty.Stamp.Duty.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StampDutyResource {

    Logger logger = LoggerFactory.getLogger(StampDutyResource.class);

    @GetMapping("/getTradingMembersEx")
    public Object getTradingMembersEx(@RequestParam("marketCode") String marketCode, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getTradingMembers?marketCode=" + marketCode + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object tradingMembers = restTemplate.getForObject(url, Object.class);

//        System.out.println(tradingMembers.getClass());

        return tradingMembers;
    }

    @GetMapping("/stakeholderRegistration/")
    public Object stakeholderRegistration(@RequestParam("marketCode") String marketCode, @RequestParam("requesterCode") String requesterCode, @RequestParam("passWord") String passWord, @RequestParam("confirmPassWord") String confirmPassWord, @RequestParam("secretQuestion") String secretQuestion, @RequestParam("answer") String answer) {

        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/register?marketCode=" + marketCode + "&requesterCode=" + requesterCode + "&passWord=" + passWord + "&confirmPassWord=" + confirmPassWord + "&secretQuestion=" + secretQuestion + "&answer=" + answer;
        RestTemplate restTemplate = new RestTemplate();
        Object registeredUser = restTemplate.getForObject(url, Object.class);

        return registeredUser;
    }

    @GetMapping("/getStakeHolderProfile/")
    public Object getStakeHolderProfile(@RequestParam("emailAddress") String emailAddress, @RequestParam("password") String password, @RequestParam("returnType") String returnType) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getStakeHolderProfile?emailAddress=" + emailAddress + "&password=" + password + "&returnType=" + returnType;
        RestTemplate restTemplate = new RestTemplate();
        Object stakeHolderProfile = restTemplate.getForObject(url, Object.class);

        return stakeHolderProfile;
    }

    @GetMapping("/getContractNotesTaxable/")
    public Object getContractNotesTaxable(@RequestParam("emailAddress") String emailAddress, @RequestParam("requesterCode") String requesterCode, @RequestParam("marketCode") String marketCode, @RequestParam("monthAndYear") String monthAndYear) {
        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getContractNotesTaxable?emailAddress=" + emailAddress + "&requesterCode=" + requesterCode + "&marketCode=" + marketCode + "&monthAndYear=" + monthAndYear;
        RestTemplate restTemplate = new RestTemplate();
        Object contractNotesTaxable = restTemplate.getForObject(url, Object.class);

        return contractNotesTaxable;
    }

    @GetMapping("/getPaymentDetails/")
    public void getPaymentDetails(@RequestParam("emailAddress") String emailAddress, @RequestParam("requesterCode") String requesterCode, @RequestParam("marketCode") String marketCode, @RequestParam("monthAndYear") String monthAndYear, @RequestParam("paymentReference") String paymentReference) {
//        String url = "http://50.116.33.99:8080/AnalyticsServices/tradeContractNotes/getContractNotesTaxable?emailAddress=" + emailAddress + "&requesterCode=" + requesterCode + "&marketCode=" + marketCode + "&monthAndYear=" + monthAndYear;
//        RestTemplate restTemplate = new RestTemplate();
//        Object contractNotesTaxable = restTemplate.getForObject(url, Object.class);
//
//        return contractNotesTaxable;

        System.out.println("This is the payment reference being called");

        logger.info("This is the email address {}", emailAddress);
        logger.info("This is the requesterCode {}", requesterCode);
        logger.info("This is the marketCode {}", marketCode);
        logger.info("This is the monthAndYear {}", monthAndYear);
        logger.info("This is the paymentReference {}", paymentReference);
    }

}
