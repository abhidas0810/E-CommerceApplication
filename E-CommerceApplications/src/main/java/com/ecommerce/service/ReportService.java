package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.ReportException;
import com.ecommerce.model.Report;

public interface ReportService {

	public Report addReport(Report report) throws ReportException;

	public Report deleteReport(Integer reportId) throws ReportException;

	public Report findByReportId(Integer reportId) throws ReportException;

	public List<Report> viewAllReports() throws ReportException;

}
