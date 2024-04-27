package com.lab.reports.service;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.reports.dto.ReportDTO;
import com.lab.reports.entity.Report;
import com.lab.reports.mapper.CustomMapper;
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

		reports.forEach(r -> reportDTOs.add(CustomMapper.MAPPER.convertReportDTO(r)));

		return reportDTOs;
	}
}
