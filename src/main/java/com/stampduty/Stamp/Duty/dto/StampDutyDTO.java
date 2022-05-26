package com.stampduty.Stamp.Duty.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StampDutyDTO {

    private String fileName;

    private long fileSize;

    private String fileType;

    private String emailAddress;

    private String tmCode;

    private String month;

    private String year;


    private byte[] data;
}
