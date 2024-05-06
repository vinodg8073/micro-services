package com.lab.user.management.enums;

import lombok.Getter;

public enum Roles {
    EDIT(1),
    VIEW(2);
	
	@Getter
	private final int value;
	
	private Roles(int value) {
		this.value = value;
	}
	
	public static int getValueFromString(String role) {
        for (Roles type : Roles.values()) {
            if (type.name().equalsIgnoreCase(role)) {
                return type.value;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + role);
    }
}
