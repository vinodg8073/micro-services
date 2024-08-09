package com.lab.user.management.dto.client;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReportDTO {
	
	private long reportId;
    private String verifiedBy;
    private String result;
    private List<String> testNames;
    private String paymentDue;
    private String issued;
}
