package com.lab.user.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.user.management.dto.UserDetails;
import com.lab.user.management.entity.Roles;
import com.lab.user.management.entity.User;
import com.lab.user.management.mapper.UserMapper;
import com.lab.user.management.repository.RolesRepository;
import com.lab.user.management.repository.UserRepository;
import com.lab.user.management.repository.UserRolesRepository;
import com.lab.user.management.repository.UserTypesRepository;

@Service
public class UserService {

	@Autowired
	private UserRolesRepository userRoleRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private UserTypesRepository userTypeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails getUserDetailsById(int userId) {
		User user = userRepository.findById(userId).get();
		List<Integer> userRoleIds = new ArrayList<Integer>();//userRoleRepository.getRoleIdsByUserId(userId);
		userRoleRepository.findByUserId(userId).forEach(ur -> userRoleIds.add(ur.getRoleId()));
		List<Roles> userRoles = rolesRepository.findAllById(userRoleIds);
		String userTypeDescription = userTypeRepository.findById(userId).get().getUserTypeDescription();
		
		UserDetails userDetails = UserMapper.MAPPER.getUserDetails(user,userRoles,userTypeDescription);
		return userDetails;
	}
	
}
