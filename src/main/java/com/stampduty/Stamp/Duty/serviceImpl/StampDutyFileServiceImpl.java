package com.stampduty.Stamp.Duty.serviceImpl;

import com.stampduty.Stamp.Duty.dto.StampDutyDTO;
import com.stampduty.Stamp.Duty.entity.StampDutyFile;
import com.stampduty.Stamp.Duty.exceptions.StampDutyFileException;
import com.stampduty.Stamp.Duty.repository.StampDutyFileRepository;
import com.stampduty.Stamp.Duty.service.StampDutyFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StampDutyFileServiceImpl implements StampDutyFileService {

    @Autowired
    StampDutyFileRepository stampDutyFileRepository;

    Logger logger = LoggerFactory.getLogger(StampDutyFileServiceImpl.class);

    @Override
    public StampDutyDTO uploadFile(MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            if (fileName.contains(".."))
                throw new StampDutyFileException("File not supported");
            else {
                StampDutyFile stampDutyFile = new StampDutyFile(fileName, multipartFile.getSize(), multipartFile.getContentType(), multipartFile.getBytes());
                stampDutyFileRepository.save(stampDutyFile);

                logger.info("FILE NAME==========> {}", fileName);
                logger.info("FILE SIZE==========> {}", multipartFile.getSize());
                logger.info("FILE TYPE==========> {}", multipartFile.getContentType());
                logger.info("FILE BYTE==========> {}", multipartFile.getBytes());

                StampDutyDTO emeraldBlogFilesDto = new StampDutyDTO(fileName, multipartFile.getSize(), multipartFile.getContentType(), multipartFile.getBytes());

                return  emeraldBlogFilesDto;
            }
        } catch (Exception ex) {
            return null;
        }
    }


    @Override
    public StampDutyFile downloadFile(Long fileId) {
        return stampDutyFileRepository.findById(fileId).orElse(null);
    }
}
