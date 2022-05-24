package com.stampduty.Stamp.Duty;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;

@Data
public class CertificateParams {

    String certificateNumber;
    String instrument;
    String parties;
    String consideration;
    String stampDutyPaid;
    String ISSD;
    String beneficiary;
    String beneficiaryTin;
    String description;
    String dateOfExecution;
    String dateOfFiling;
    String issuanceDate;
    String originatingOffice;

    public CertificateParams(String certificateNumber, String instrument, String parties, String consideration, String stampDutyPaid, String ISSD, String beneficiary, String beneficiaryTin, String description, String dateOfExecution, String dateOfFiling, String issuanceDate, String originatingOffice) {
        this.certificateNumber = certificateNumber;
        this.instrument = instrument;
        this.parties = parties;
        this.consideration = consideration;
        this.stampDutyPaid = stampDutyPaid;
        this.ISSD = ISSD;
        this.beneficiary = beneficiary;
        this.beneficiaryTin = beneficiaryTin;
        this.description = description;
        this.dateOfExecution = dateOfExecution;
        this.dateOfFiling = dateOfFiling;
        this.issuanceDate = issuanceDate;
        this.originatingOffice = originatingOffice;
    }
}
