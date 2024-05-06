package com.lab.user.management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.lab.user.management.dto.UserDetailsDTO;
import com.lab.user.management.entity.Roles;
import com.lab.user.management.entity.User;
import com.lab.user.management.entity.UserRoles;
import com.lab.user.management.enums.UserTypes;

@Mapper
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "active", source = "user.active", qualifiedByName = "mapIntToBoolean")
	public UserDetailsDTO getUserDetails(User user , List<Roles> roles, String userType);
	
	@Mapping(target = "active", source = "userDetails.active", qualifiedByName = "mapBooleanToInt")
	@Mapping(target = "userTypeId", source = "userDetails.userType", qualifiedByName = "getUserTypeId")
	public User getUser(UserDetailsDTO userDetails);
	
//	@Mapping(target = "userId", source = "userId")
//	@Mapping(target = "roleId", source = "roles[]", qualifiedByName = "getUserTypeId")
//	public List<UserRoles> getUserRoles(int userId, List<String> roles);
	@Named("mapIntToBoolean")
	default boolean mapIntToBoolean(int active) {
		return active>0;
	}
	
	@Named("mapBooleanToInt")
	default int mapBooleanToInt(boolean active) {
		return active ? 1 : 0;
	}
	
	@Named("getUserTypeId")
	default int getUserTypeId(String userType) {
		return UserTypes.getValueFromString(userType);
	}

}