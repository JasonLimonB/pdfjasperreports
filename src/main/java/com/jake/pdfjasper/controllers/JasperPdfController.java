package com.jake.pdfjasper.controllers;

import com.jake.pdfjasper.services.JasperPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf")
public class JasperPdfController {

    @Autowired
    private JasperPdfService jasperPdfService;

    @GetMapping
    public void createPdf(){
        jasperPdfService.generatePdf();
    }

}
