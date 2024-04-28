package com.lab.reports.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "lab_reports")
public class Report extends AuditBaseEntity {
	@Id
	private long reportId;
	private long patientId;
	private String verifiedBy;
	private String testedBy;
	private int issued;
	private int paymentReceived;
	private double totalAmount;
	private double receivedAmount;
}
