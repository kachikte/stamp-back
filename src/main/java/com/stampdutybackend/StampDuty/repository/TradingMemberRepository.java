package com.stampdutybackend.StampDuty.repository;

import com.stampdutybackend.StampDuty.entity.TradingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingMemberRepository extends JpaRepository<TradingMember, Long> {
}
