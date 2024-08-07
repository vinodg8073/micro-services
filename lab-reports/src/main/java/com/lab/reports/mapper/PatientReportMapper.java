package com.lab.reports.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.lab.reports.dto.ReportDTO;
import com.lab.reports.entity.Report;
import com.lab.reports.entity.ReportResult;
import com.lab.reports.entity.ReportTestDetails;

@Mapper(componentModel = "spring")
public interface PatientReportMapper {
	PatientReportMapper MAPPER = Mappers.getMapper(PatientReportMapper.class);
	
	@Mappings({
        @Mapping(source = "report.reportId", target = "reportId"),
        @Mapping(source = "report.verifiedBy", target = "verifiedBy"),
        @Mapping(source = "reportResult.result", target = "result"),
        @Mapping(source = "report.testDetails", target = "testNames", qualifiedByName = "testDetailsToTestNames"),
        @Mapping(source = "report.paymentReceived", target = "paymentDue",qualifiedByName = "paymentReceivedToYesNO"),
        @Mapping(source = "report.issued", target = "issued")
    })
	ReportDTO toReportDTO(Report report, ReportResult reportResult);
	
	@org.mapstruct.Named("testDetailsToTestNames")
    default List<String> mapTestDetailsToTestNames(List<ReportTestDetails> reportTestDetails) {
        return reportTestDetails.stream()
                                .map(reportTestDetails1 -> reportTestDetails1.getLabTest().getTestName())
                                .collect(Collectors.toList());
    }
    
	@org.mapstruct.Named("paymentReceivedToYesNO")
    default String mapPaymentReceivedToYesNo(int paymentReceived) {
        return paymentReceived == 1 ? "No" : "Yes";
    }
}
