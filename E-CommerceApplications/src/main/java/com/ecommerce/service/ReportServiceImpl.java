package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ReportException;
import com.ecommerce.model.Report;
import com.ecommerce.repository.ReportRepo;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepo reportRepo;

	@Override
	public Report addReport(Report report) throws ReportException {
		Report report2 = reportRepo.save(report);
		if (report2 == null) {
			throw new ReportException("Report can not be added.");
		}
		return report2;
	}

	@Override
	public Report deleteReport(Integer reportId) throws ReportException {
		Report report = reportRepo.findById(reportId)
				.orElseThrow(() -> new ReportException("Report not found with reportId : " + reportId));
		reportRepo.delete(report);
		return report;
	}

	@Override
	public Report findByReportId(Integer reportId) throws ReportException {
		Report report = reportRepo.findById(reportId)
				.orElseThrow(() -> new ReportException("Report not found with reportId : " + reportId));
		return report;
	}

	@Override
	public List<Report> viewAllReports() throws ReportException {
		List<Report> reports = reportRepo.findAll();
		if (reports.isEmpty()) {
			throw new ReportException("No reports found.");
		}
		return reports;
	}

}
