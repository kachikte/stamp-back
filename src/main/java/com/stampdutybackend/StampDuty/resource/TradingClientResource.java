package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.TradingClientDto;
import com.stampdutybackend.StampDuty.entity.TradingClient;
import com.stampdutybackend.StampDuty.service.TradingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TradingClientResource {

    @Autowired
    TradingClientService tradingClientService;

    @GetMapping("/getTradingClient/")
    public List<TradingClient> getTradingClient()  {
        return tradingClientService.getTradingClients();
    }

    @PostMapping("/addTradingClient/")
    public TradingClient addTradingClient(@RequestBody TradingClientDto tradingClientDto) {
        return tradingClientService.addTradingClient(tradingClientDto);
    }
}
