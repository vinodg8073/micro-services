package com.lab.user.management.service;

import com.lab.user.management.dto.UserDetailsPageDTO;

public interface IUserDetailsPageService {

	public UserDetailsPageDTO getCompleteUserDetails(int userId);
}
