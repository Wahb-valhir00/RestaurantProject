package com.elife.projet_ff.controller;

import com.elife.projet_ff.model.Report;
import com.elife.projet_ff.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/create")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report createdReport = reportService.createReport(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable String id) {
        Report report = reportService.getReportById(id);
        return new ResponseEntity<>(report, report != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable String id, @RequestBody Report report) {
        Report updatedReport = reportService.updateReport(id, report);
        return new ResponseEntity<>(updatedReport, updatedReport != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable String id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}