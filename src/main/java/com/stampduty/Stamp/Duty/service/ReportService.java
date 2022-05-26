package com.stampduty.Stamp.Duty.service;

import com.stampduty.Stamp.Duty.CertificateParams;
import com.stampduty.Stamp.Duty.dto.CertificateDataDto;
import com.stampduty.Stamp.Duty.dto.StampDutyDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface ReportService {

    StampDutyDTO exportReport(String reportFormat, CertificateDataDto certificateDataDto) throws IOException, JRException;
}
