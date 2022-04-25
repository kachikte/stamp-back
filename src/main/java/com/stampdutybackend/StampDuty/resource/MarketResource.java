package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.MarketDto;
import com.stampdutybackend.StampDuty.entity.Market;
import com.stampdutybackend.StampDuty.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarketResource {

    @Autowired
    MarketService marketService;

    @GetMapping("/getMarket/")
    public List<Market> getMarket() {
        List<Market> markets =  marketService.getMarket();
        return markets;
    }

    @PostMapping("/addMarket/")
    public Market addMarket(@RequestBody MarketDto marketDto) {
        return marketService.addMarket(marketDto);
    }

}
