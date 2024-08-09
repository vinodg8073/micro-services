package com.lab.user.management.dto;

import java.util.List;

import com.lab.user.management.dto.client.ReportDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CompleteUserDetails", description = "Schema to hold complete lab user details")
public class UserDetailsPageDTO {
	private UserDetailsDTO userDetails;
	private List<ReportDTO> reports;
}
