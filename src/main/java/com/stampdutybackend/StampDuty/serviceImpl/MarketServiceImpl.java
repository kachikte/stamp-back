package com.stampdutybackend.StampDuty.serviceImpl;

import com.stampdutybackend.StampDuty.dto.MarketDto;
import com.stampdutybackend.StampDuty.entity.Market;
import com.stampdutybackend.StampDuty.repository.MarketRepository;
import com.stampdutybackend.StampDuty.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    MarketRepository marketRepository;

    @Override
    public Market addMarket(MarketDto marketDto) {
        Market market = new Market();

        market.setMarketPlaceCode(marketDto.getMarketPlaceCode());
        market.setMarketPlaceType(marketDto.getMarketPlaceType());
        market.setTotalGrosssAmount(marketDto.getTotalGrosssAmount());
        market.setTotalStampDutyFees(marketDto.getTotalStampDutyFees());
        market.setVatOnExchangeFees(marketDto.getVatOnExchangeFees());
        market.setTotalExchangeFees(marketDto.getTotalExchangeFees());

        return marketRepository.save(market);

    }

    @Override
    public List<Market> getMarket() {
        return marketRepository.findAll();
    }
}