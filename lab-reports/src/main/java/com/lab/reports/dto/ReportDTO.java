package com.lab.reports.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReportDTO {
	
	private long id;
	private LocalDateTime date;
	private String verifiedBy;
	private int issued;
}
