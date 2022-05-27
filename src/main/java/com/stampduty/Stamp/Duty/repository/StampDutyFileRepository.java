package com.stampduty.Stamp.Duty.repository;

import com.stampduty.Stamp.Duty.entity.StampDutyFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface StampDutyFileRepository  extends CrudRepository<StampDutyFile, Long> {

    @Query("SELECT s FROM StampDutyFile s where s.emailAddress = ?1 AND s.tmCode = ?2 AND s.month = ?3 AND s.year = ?4")
    StampDutyFile getStampDutyFileByParams(String emailAddress, String tmCode, String month, String year);
}


