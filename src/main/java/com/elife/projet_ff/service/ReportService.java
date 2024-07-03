package com.elife.projet_ff.service;

import com.elife.projet_ff.model.Report;
import com.elife.projet_ff.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(String id) {
        return reportRepository.findById(id).orElse(null);
    }

    public Report updateReport(String id, Report report) {
        Report existingReport = getReportById(id);
        if (existingReport != null) {
            existingReport.setUser(report.getUser());
            existingReport.setRestaurant(report.getRestaurant());
            existingReport.setMessage(report.getMessage());
            return reportRepository.save(existingReport);
        }
        return null;
    }

    public void deleteReport(String id) {
        reportRepository.deleteById(id);
    }
}