package com.lab.user.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.user.management.dto.UserDetailsPageDTO;
import com.lab.user.management.enums.UserTypes;
import com.lab.user.management.repository.UserRolesRepository;
import com.lab.user.management.service.IUserDetailsPageService;
import com.lab.user.management.service.UserService;
import com.lab.user.management.service.client.ReportFeignClient;

@Service
public class UserDetailsPageService implements IUserDetailsPageService {

	@Autowired
	private ReportFeignClient reportFeignClient;
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetailsPageDTO getCompleteUserDetails(int userId) {
		var userDetails = userService.getUserDetailsById(userId);
		
		UserDetailsPageDTO completeuserDetails = new UserDetailsPageDTO();
		completeuserDetails.setUserDetails(userDetails);
		if(UserTypes.getValueFromString(userDetails.getUserType()) == UserTypes.PATIENT.getValue()  && userDetails != null) {
			var reports = reportFeignClient.getReports(userId).getBody();
			completeuserDetails.setReports(reports); 
		}
		
		return completeuserDetails;
	}

}
