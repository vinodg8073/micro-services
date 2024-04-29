package com.lab.user.management.dto;

import java.util.List;

import com.lab.user.management.entity.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDetails {

	private String name;
	private boolean active;
	private String userType;
	private List<Roles> roles;
}
