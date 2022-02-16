package com.stampdutybackend.StampDuty.serviceImpl;

import com.stampdutybackend.StampDuty.dto.TradingClientDto;
import com.stampdutybackend.StampDuty.dto.TradingMemberDto;
import com.stampdutybackend.StampDuty.entity.TradingClient;
import com.stampdutybackend.StampDuty.entity.TradingMember;
import com.stampdutybackend.StampDuty.repository.TradingClientRepository;
import com.stampdutybackend.StampDuty.repository.TradingMemberRepository;
import com.stampdutybackend.StampDuty.service.TradingClientService;
import com.stampdutybackend.StampDuty.service.TradingMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingClientServiceImpl implements TradingClientService {

    @Autowired
    TradingClientRepository tradingClientRepository;

    @Autowired
    TradingMemberRepository tradingMemberRepository;

    @Override
    public List<TradingClient> getTradingClients() {
        return tradingClientRepository.findAll();
    }

    @Override
    public TradingClient addTradingClient(TradingClientDto tradingClientDto) {
        TradingClient tradingClient = new TradingClient();

        TradingMember tradingMember = tradingMemberRepository.getById(tradingClientDto.getTradingMemberId());

        tradingClient.setAccountNumber(tradingClientDto.getAccountNumber());
        tradingClient.setTotalGrossAmount(tradingClientDto.getTotalGrossAmount());
        tradingClient.setTotalStampDutyFees(tradingClientDto.getTotalStampDutyFees());
        tradingClient.setTotalBrokerageFees(tradingClientDto.getTotalBrokerageFees());
        tradingClient.setTotalExchangeFees(tradingClientDto.getTotalExchangeFees());
        tradingClient.setTotalCentralSecurityDepositFees(tradingClientDto.getTotalCentralSecurityDepositFees());
        tradingClient.setTotalTradeAlertFees(tradingClientDto.getTotalTradeAlertFees());
        tradingClient.setTotalSecFees(tradingClientDto.getTotalSecFees());
        tradingClient.setTradingMember(tradingMember);

        return tradingClientRepository.save(tradingClient);
    }
}