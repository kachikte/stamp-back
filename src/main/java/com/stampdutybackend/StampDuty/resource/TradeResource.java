package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.TradeDto;
import com.stampdutybackend.StampDuty.entity.Trade;
import com.stampdutybackend.StampDuty.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TradeResource {

    @Autowired
    TradeService tradeService;

    @GetMapping("/getTrades/")
    public List<Trade> getTrades() {
        return tradeService.getTrades();
    }

    @PostMapping("/addTrade/")
    public Trade addTrade(@RequestBody TradeDto tradeDto) {
        return tradeService.addTrade(tradeDto);
    }
}
