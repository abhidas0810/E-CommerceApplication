package com.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;

	@NotNull
	private String reportName;
	private String reportType;
	private String reportDetails;

	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;

	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(Integer reportId, @NotNull String reportName, String reportType, String reportDetails, Admin admin) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
		this.reportDetails = reportDetails;
		this.admin = admin;
	}

	public Report(@NotNull String reportName, String reportType, String reportDetails, Admin admin) {
		super();
		this.reportName = reportName;
		this.reportType = reportType;
		this.reportDetails = reportDetails;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType
				+ ", reportDetails=" + reportDetails + ", admin=" + admin + "]";
	}

}
