package com.demo.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.EMS.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
