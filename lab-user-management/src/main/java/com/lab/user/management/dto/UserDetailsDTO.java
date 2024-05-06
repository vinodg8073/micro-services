package com.lab.user.management.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lab.user.management.entity.Roles;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "USerDetails", description = "Schema to hold Lab user details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsDTO {

	@Schema(hidden = true)
	private int userId;
	@Schema(description = "Name of the user", example = "ABC")
	private String name;
	private boolean active;
	private String userType;
	private List<Roles> roles;
}
