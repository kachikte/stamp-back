package com.stampdutybackend.StampDuty.repository;

import com.stampdutybackend.StampDuty.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
}
