package com.niit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUserid(int userid);
	User findByUsername(String username);
	User findByEmail(String email);
}
