package com.lab.user.management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.lab.user.management.controller.UserController;
import com.lab.user.management.dto.UserDetails;
import com.lab.user.management.entity.Roles;
import com.lab.user.management.entity.User;

@Mapper
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "active", source = "user.active", qualifiedByName = "mapIntToBoolean")
	public UserDetails getUserDetails(User user , List<Roles> roles, String userType);
	
	@Named("mapIntToBoolean")
	default boolean mapIntToBoolean(int active) {
		return active>0;
	}
}