package com.lab.user.management.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.lab.user.management.dto.client.ReportDTO;

@FeignClient(name = "lab-reports")
public interface ReportFeignClient {

	@GetMapping(value = "/reports/api/v1/getReports/{patientId}", consumes = "application/json")
	public ResponseEntity<List<ReportDTO>> getReports(@PathVariable long patientId);
	
}
