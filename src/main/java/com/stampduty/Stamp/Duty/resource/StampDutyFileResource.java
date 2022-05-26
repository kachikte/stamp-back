package com.stampduty.Stamp.Duty.resource;

import com.stampduty.Stamp.Duty.dto.StampDutyDTO;
import com.stampduty.Stamp.Duty.entity.StampDutyFile;
import com.stampduty.Stamp.Duty.service.StampDutyFileService;
import com.stampduty.Stamp.Duty.utils.StampDutyResponseCodes;
import com.stampduty.Stamp.Duty.utils.StampDutyResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class StampDutyFileResource {

    @Autowired
    StampDutyFileService stampDutyFileService;

    Logger logger = LoggerFactory.getLogger(StampDutyResource.class);


    @PostMapping("/upload-file")
    public ResponseEntity<StampDutyResponseEntity> uploadFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        StampDutyDTO stampDutyDTO = stampDutyFileService.uploadFile(file);

        logger.info("REQUEST PATH========>{}", request.getPathInfo());

        logger.info("REQUEST PATH 2 ONLY========>{}", ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path("p")
                .toUriString());

        StampDutyResponseEntity emeraldResponseEntity = new StampDutyResponseEntity(StampDutyResponseCodes.SUCCESS_CODE, StampDutyResponseCodes.SUCCESS_MESSAGE, stampDutyDTO);
        return ResponseEntity.ok(emeraldResponseEntity);
    }



    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id) {
        StampDutyFile stampDutyFile = stampDutyFileService.downloadFile(id);

        if (stampDutyFile != null) {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(stampDutyFile.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, stampDutyFile.getFileName())
                    .body(new ByteArrayResource(stampDutyFile.getData()));
        } else {
            return null;
        }
    }

}
