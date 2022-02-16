package com.stampdutybackend.StampDuty.service;

import com.stampdutybackend.StampDuty.dto.MarketDto;
import com.stampdutybackend.StampDuty.entity.Market;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MarketService {

    Market addMarket(MarketDto marketDto);

    List<Market> getMarket();
}
