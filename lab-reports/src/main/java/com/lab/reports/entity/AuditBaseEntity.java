package com.lab.reports.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter 
@ToString
public class AuditBaseEntity {

	private LocalDateTime createdDate;
	private String createdBy;
	private LocalDateTime updatedDate;
	private String updatedBy;
}
