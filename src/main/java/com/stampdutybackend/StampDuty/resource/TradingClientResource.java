package com.stampdutybackend.StampDuty.resource;

import com.stampdutybackend.StampDuty.dto.TradingClientDto;
import com.stampdutybackend.StampDuty.entity.TradingClient;
import com.stampdutybackend.StampDuty.service.TradingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
