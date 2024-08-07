package com.lab.reports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Holds the JSON result. In future will be used by pdf service
 * 
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lab_report_results")
public class ReportResult extends AuditBaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String result;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_id", referencedColumnName = "report_id")
	private Report report;
}
