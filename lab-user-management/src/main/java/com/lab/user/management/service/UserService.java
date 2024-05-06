package com.lab.user.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.user.management.dto.UserDetailsDTO;
import com.lab.user.management.entity.Roles;
import com.lab.user.management.entity.User;
import com.lab.user.management.entity.UserRoles;
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

	public UserDetailsDTO getUserDetailsById(int userId) {
		User user = userRepository.findById(userId).get();
		List<Integer> userRoleIds = new ArrayList<Integer>();// userRoleRepository.getRoleIdsByUserId(userId);
		userRoleRepository.findByUserId(userId).forEach(ur -> userRoleIds.add(ur.getRoleId()));
		List<Roles> userRoles = rolesRepository.findAllById(userRoleIds);
		String userTypeDescription = userTypeRepository.findById(userId).get().getUserTypeDescription();

		UserDetailsDTO userDetails = UserMapper.MAPPER.getUserDetails(user, userRoles, userTypeDescription);
		return userDetails;
	}

	public boolean updateUserDetails(UserDetailsDTO userDetails) {

		User existingUser = userRepository.findById(userDetails.getUserId()).get();
		int userId = userDetails.getUserId();
		if (existingUser == null || userId == 0)
			return false;
		User user = UserMapper.MAPPER.getUser(userDetails);

		// bug
		String password = existingUser.getPassword();
		user.setPassword(password);

		List<UserRoles> roles = new ArrayList<UserRoles>();

		userDetails.getRoles().forEach(role -> {
			UserRoles userRole = new UserRoles();
			userRole.setUserId(userId);
			userRole.setRoleId(com.lab.user.management.enums.Roles.getValueFromString(role.getRole()));
			roles.add(userRole);
		});

		userRepository.save(user);
		userRoleRepository.deleteByUserId(userId);
		userRoleRepository.saveAll(roles);
		return true;

	}

	public boolean createUser(User user) {
		int userId = user.getUserId();
		var existingUser = userRepository.findById(userId);
		if (!existingUser.isEmpty())
			return false;

		userRepository.save(user);
		return true;

	}

	public boolean deleteUser(int userId) {
		var existingUser = userRepository.findById(userId);
		if (existingUser.isEmpty())
			return false;
		List<UserRoles> roles = userRoleRepository.findByUserId(userId);
		if (!roles.isEmpty())
			userRoleRepository.deleteByUserId(userId);
		userRepository.deleteById(userId);
		return true;

	}

}
