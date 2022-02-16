package com.stampdutybackend.StampDuty.repository;

import com.stampdutybackend.StampDuty.entity.TradingClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingClientRepository extends JpaRepository<TradingClient, Long> {
}
