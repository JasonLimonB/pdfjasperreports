package com.jake.pdfjasper.services;

import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperPdfService {

    private final Logger log = LoggerFactory.getLogger(JasperPdfService.class);

    public void generatePdf(){

        log.info("Pdf started...");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jason Limon");

        try {
            String path = "/Users/jasonlimon/Documents/Learning/pdfjasper/src/main/resources";

            InputStream file = getClass().getResourceAsStream("/reports/Last.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JREmptyDataSource(1));

            JasperExportManager.exportReportToPdfFile(jasperPrint, path +"/ReportesGenerados/Last.pdf");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
