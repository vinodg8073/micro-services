package com.lab.reports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.reports.dto.ReportDTO;
import com.lab.reports.service.ReportService;

@RestController
@RequestMapping(path = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ReportsController {

	@Autowired
	ReportService reportService;

	@GetMapping("/getReports/{patientId}")
	public ResponseEntity<List<ReportDTO>> getReports(@PathVariable long patientId) {
		var response = reportService.getAllReports(patientId);
		HttpStatusCode statusCode;
		if (response == null)
			statusCode = HttpStatus.NO_CONTENT;
		else
			statusCode = HttpStatus.OK;
		return ResponseEntity.status(statusCode).body(response);
	}
}
