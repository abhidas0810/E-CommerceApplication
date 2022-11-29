package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.ReportException;
import com.ecommerce.model.Report;
import com.ecommerce.service.ReportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	/*--------------------------------------------Report Controller--------------------------- */

	@PostMapping("/report")
	public ResponseEntity<Report> addReportHandler(@RequestBody Report report) throws ReportException {
		return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/report/{reportId}")
	public ResponseEntity<Report> deleteReportHandler(@PathVariable("reportId") Integer reportId)
			throws ReportException {
		return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
	}

	@GetMapping("/report/{reportId}")
	public ResponseEntity<Report> findByReportIdHandler(@PathVariable("reportId") Integer reportId)
			throws ReportException {
		return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
	}

	@GetMapping("/reports")
	public ResponseEntity<List<Report>> viewAllReportsHandler() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}

}
