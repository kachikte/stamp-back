package com.stampduty.Stamp.Duty.service;

import com.stampduty.Stamp.Duty.CertificateParams;
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

@Service
public class ReportService {

    Logger logger = LoggerFactory.getLogger(ReportService.class);


    public String exportReport(String reportFormat) throws IOException, JRException {
        String path = "../../";
        final String fileNameHtml = File.createTempFile("adddadha", ".html").getAbsolutePath();
        final String fileNamePdf = File.createTempFile("adddadha", ".pdf").getAbsolutePath();
        List<CertificateParams> certificateParamsList = new ArrayList<>();
        CertificateParams certificateParams = new CertificateParams(
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "A",
                "A",
                "a",
                "a"
        );
        certificateParamsList.add(certificateParams);
        //load file
        File file = ResourceUtils.getFile("classpath:certificate.jrxml");
        logger.info("This is the file path {}", fileNamePdf);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(certificateParamsList);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("createdBy", "Onochie-okeke Onyekachi S.");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, fileNameHtml);
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileNamePdf);
        }

        return "Report generated at " ;
    }
}
