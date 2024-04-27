package com.lab.reports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.reports.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
	/*
	 * JPA automatically creates query based on patientId field
	 */
	public List<Report> findByPatientId(long patientId); 
}
