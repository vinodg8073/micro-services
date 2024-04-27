package com.lab.reports.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lab.reports.dto.ReportDTO;
import com.lab.reports.entity.Report;

@Mapper
/*
 * MapStruct creates the implementation at compile time under target/generated-sources/annotations
 * Read https://www.baeldung.com/mapstruct for more like mapping b/w child beans, 
 * mapping different fields, w/ dependency, map w/ type conversion, etc...
 */
public interface CustomMapper {
	
	CustomMapper MAPPER = Mappers.getMapper(CustomMapper.class);
	
	@Mapping(target = "id", source = "report.reportId")
	@Mapping(target = "date", source = "report.createdDate")
	public ReportDTO convertReportDTO(Report report);
}
