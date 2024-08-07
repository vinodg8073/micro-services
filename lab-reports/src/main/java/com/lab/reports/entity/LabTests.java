package com.lab.reports.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "lab_tests")
public class LabTests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
    private long testId;

    @Column(name = "test_name")
    private String testName;
	
	//Optional, back-reference
    @OneToMany(mappedBy = "labTest", fetch = FetchType.LAZY)
    private List<ReportTestDetails> reportTestDetails;
}
