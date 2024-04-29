package com.lab.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.user.management.entity.UserType;

@Repository
public interface UserTypesRepository extends JpaRepository<UserType, Integer>{

}
