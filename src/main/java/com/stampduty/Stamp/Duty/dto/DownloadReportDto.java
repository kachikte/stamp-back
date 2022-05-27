package com.stampduty.Stamp.Duty.dto;

import lombok.Data;

@Data
public class DownloadReportDto {
    String emailAddress;
    String tmCode;
    int month;
    String year;
}
