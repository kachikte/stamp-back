package com.stampdutybackend.StampDuty.service;

import com.stampdutybackend.StampDuty.dto.TradingClientDto;
import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.TradingClient;

import java.util.List;

public interface TradingClientService {

    List<TradingClient> getTradingClients();

    TradingClient addTradingClient(TradingClientDto tradingClientDto);
}
