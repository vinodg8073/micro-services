package com.lab.user.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "lab_users")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {

	@Id
	private int userId;
	private  String name;
	private int active;
	private String password;
	private int userTypeId;
}
