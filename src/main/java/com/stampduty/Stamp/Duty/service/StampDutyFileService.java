package com.stampduty.Stamp.Duty.service;

import com.stampduty.Stamp.Duty.dto.StampDutyDTO;
import com.stampduty.Stamp.Duty.entity.StampDutyFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public interface StampDutyFileService {

    StampDutyDTO uploadFile(MultipartFile multipartFile);

    StampDutyFile downloadFile(Long fileId);
}
