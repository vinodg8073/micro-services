package com.lab.user.management.enums;

import lombok.Getter;

public enum UserTypes {
	ADMIN(1),
	TECHNICIAN(2),
	PATIENT(3);
	
	@Getter
	private final int value;
	
	private UserTypes(int value) {
		this.value = value;
	}
	
	public static int getValueFromString(String userType) {
        for (UserTypes type : UserTypes.values()) {
            if (type.name().equalsIgnoreCase(userType)) {
                return type.value;
            }
        }
        throw new IllegalArgumentException("Invalid user type: " + userType);
    }
	
}
