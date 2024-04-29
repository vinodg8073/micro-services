package com.lab.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.user.management.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{

}
