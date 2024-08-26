package com.lab.user.management.service.client.fallback;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lab.user.management.dto.client.ReportDTO;
import com.lab.user.management.service.client.ReportFeignClient;

@Component
public class ReportFeignClientFallBack implements ReportFeignClient {

	//If fall back is not created then it throws runtime exception
	@Override
	public ResponseEntity<List<ReportDTO>> getReports(long patientId) {
		return null;  //return based on business- cache, db, null
	}

}
