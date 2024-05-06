package com.lab.user.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lab.user.management.entity.UserRoles;

import jakarta.transaction.Transactional;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

	public List<UserRoles> findByUserId(int userId);
	
	@Transactional
	 @Modifying
	public void deleteByUserId(int l);

//	@Query("SELECT ur.role_id FROM user_roles ur WHERE ur.user_id = :userId")
//	public List<Integer> getRoleIdsByUserId(int userId);
}
