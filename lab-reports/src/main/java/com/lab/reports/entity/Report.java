package com.lab.reports.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Holds details and status of the report
 * 
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lab_reports")
public class Report extends AuditBaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="report_id")
	private long reportId;
	@Column(name = "patient_id")
    private long patientId;

    @Column(name = "verified_by")
    private String verifiedBy;

    @Column(name = "tested_by")
    private String testedBy;

    @Column(name = "issued")
    private int issued;

    @Column(name = "payment_received")
    private int paymentReceived;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "received_amount")
    private double receivedAmount;

//	@ElementCollection
//	@CollectionTable(name = "lab_report_id_test_ids", joinColumns = @JoinColumn(name = "report_id"))
//	@Column(name = "test_id")
//	private List<Long> testIds;

	@OneToOne(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ReportResult reportResult;

	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReportTestDetails> testDetails;

}
