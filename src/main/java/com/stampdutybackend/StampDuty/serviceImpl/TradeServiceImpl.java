package com.stampdutybackend.StampDuty.serviceImpl;

import com.stampdutybackend.StampDuty.dto.TradeDto;
import com.stampdutybackend.StampDuty.entity.Trade;
import com.stampdutybackend.StampDuty.entity.TradingClient;
import com.stampdutybackend.StampDuty.repository.TradeRepository;
import com.stampdutybackend.StampDuty.repository.TradingClientRepository;
import com.stampdutybackend.StampDuty.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    TradingClientRepository tradingClientRepository;

    @Override
    public List<Trade> getTrades() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade addTrade(TradeDto tradeDto) {
        TradingClient tradingClient = tradingClientRepository.getById(tradeDto.getTradingClientId());

        Trade trade = new Trade();

        trade.setExecutionId(tradeDto.getExecutionId());
        trade.setSecurityCode(tradeDto.getSecurityCode());
        trade.setSecurityType(tradeDto.getSecurityType());
        trade.setMarketSegmentId(tradeDto.getMarketSegmentId());
        trade.setQuantity(tradeDto.getQuantity());
        trade.setPrice(tradeDto.getPrice());
        trade.setTransactionTime(tradeDto.getTransactionTime());
        trade.setSettlementDate(tradeDto.getSettlementDate());
        trade.setNumberOfSide(tradeDto.getNumberOfSide());
        trade.setGrossTradeAmount(tradeDto.getGrossTradeAmount());
        trade.setSide(tradeDto.getSide());
        trade.setOrderId(tradeDto.getOrderId());
        trade.setClientOrderId(tradeDto.getClientOrderId());
        trade.setAccountNumber(tradeDto.getAccountNumber());
        trade.setTradingClient(tradingClient);

        return tradeRepository.save(trade);
    }
}