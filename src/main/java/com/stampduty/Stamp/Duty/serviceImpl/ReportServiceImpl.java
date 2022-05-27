package com.stampduty.Stamp.Duty.serviceImpl;

import com.stampduty.Stamp.Duty.CertificateParams;
import com.stampduty.Stamp.Duty.dto.CertificateDataDto;
import com.stampduty.Stamp.Duty.dto.StampDutyDTO;
import com.stampduty.Stamp.Duty.service.ReportService;
import com.stampduty.Stamp.Duty.service.StampDutyFileService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    StampDutyFileService stampDutyFileService;

    Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);


    @Override
    public StampDutyDTO exportReport(CertificateDataDto certificateDataDto) throws IOException, JRException {

        //Content types

        //https://social.msdn.microsoft.com/Forums/en-US/bbfb2a32-b7eb-443e-a32b-b9be14b98a10/response-content-type-for-all-type-of-file-and-for-all-browser?forum=aspgettingstarted

        String path = "../../";
        StampDutyDTO stampDutyDTO = new StampDutyDTO();
        final String fileNameHtml = File.createTempFile("adddadha", ".html").getAbsolutePath();
        final String fileNamePdf = File.createTempFile("adddadha", ".pdf").getAbsolutePath();
        List<CertificateParams> certificateParamsList = new ArrayList<>();
        CertificateParams certificateParams = new CertificateParams(
                certificateDataDto.getCertificateNumber(),
                certificateDataDto.getInstrument(),
                certificateDataDto.getParties(),
                certificateDataDto.getConsideration(),
                certificateDataDto.getStampDutyPaid(),
                certificateDataDto.getIssd(),
                certificateDataDto.getBeneficiary(),
                certificateDataDto.getBeneficiaryTin(),
                certificateDataDto.getDecription(),
                certificateDataDto.getDateOfExecution(),
                certificateDataDto.getDateOfFiling(),
                certificateDataDto.getIssuanceDate(),
                certificateDataDto.getOriginatingOffice()
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
        if (certificateDataDto.getReportType().equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, fileNameHtml);

            File fileHtml = new File(fileNameHtml);
            Path pathHtml = Paths.get(fileNameHtml);
            String name = "file.html";
            String originalFileName = fileHtml.getName();
            String contentType = "text/HTML";
//            String contentType = "text/plain";
            byte[] content = null;
            try {
                content = Files.readAllBytes(pathHtml);
            } catch (final IOException e) {
            }
            MultipartFile result = new MockMultipartFile(name,
                    originalFileName, contentType, content);
            stampDutyDTO = stampDutyFileService.uploadFile(result, certificateDataDto.getEmailAddress(), certificateDataDto.getTmCode(), certificateDataDto.getMonth(), certificateDataDto.getYear());
        }
        if (certificateDataDto.getReportType().equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileNamePdf);
            File filePdf = new File(fileNamePdf);
            Path pathPdf = Paths.get(fileNamePdf);
            String name = "file.pdf";
            String originalFileName = filePdf.getName();
            String contentType = "application/pdf";
//            String contentType = "text/plain";
            byte[] content = null;
            try {
                content = Files.readAllBytes(pathPdf);
            } catch (final IOException e) {
            }
            MultipartFile result = new MockMultipartFile(name,
                    originalFileName, contentType, content);
            stampDutyDTO = stampDutyFileService.uploadFile(result, certificateDataDto.getEmailAddress(), certificateDataDto.getTmCode(), certificateDataDto.getMonth(), certificateDataDto.getYear());
        }

        return stampDutyDTO;
    }
}
