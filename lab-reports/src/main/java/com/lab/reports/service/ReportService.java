package com.lab.reports.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.reports.dto.ReportDTO;
import com.lab.reports.entity.Report;
import com.lab.reports.mapper.PatientReportMapper;
import com.lab.reports.repository.ReportRepository;

@Service
public class ReportService {

	@Autowired
	ReportRepository reportRepository;

	public List<ReportDTO> getAllReports(long patientId) {
		List<Report> reports = reportRepository.findByPatientId(patientId);
		if (reports.isEmpty() || reports == null)
			return null;

		List<ReportDTO> reportDTOs = new ArrayList<ReportDTO>();

		reports.forEach(r -> reportDTOs.add(PatientReportMapper.MAPPER.toReportDTO(r,r.getReportResult())));
		System.out.println(reportDTOs.get(0).toString());	
		return reportDTOs;
	}
}
