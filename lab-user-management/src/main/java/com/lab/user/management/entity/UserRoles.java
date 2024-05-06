package com.lab.user.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long userId;
	private int roleId;
}
