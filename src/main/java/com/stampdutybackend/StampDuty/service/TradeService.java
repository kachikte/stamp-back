package com.stampdutybackend.StampDuty.service;

import com.stampdutybackend.StampDuty.dto.TradeDto;
import com.stampdutybackend.StampDuty.entity.Trade;

import java.util.List;

public interface TradeService {

    List<Trade> getTrades();

    Trade addTrade(TradeDto tradeDto);
}
