package com.stampduty.Stamp.Duty.repository;

import com.stampduty.Stamp.Duty.entity.StampDutyFile;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface StampDutyFileRepository  extends CrudRepository<StampDutyFile, Long> {
}


