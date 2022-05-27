package com.stampduty.Stamp.Duty.dto;

import lombok.Data;

@Data
public class CertificateDataDto {
    String reportType;
    String certificateNumber;
    String instrument;
    String parties;
    String consideration;
    String stampDutyPaid;
    String issd;
    String beneficiary;
    String beneficiaryTin;
    String decription;
    String dateOfExecution;
    String dateOfFiling;
    String issuanceDate;
    String originatingOffice;
    String emailAddress;
    String tmCode;
    String month;
    String year;
}
