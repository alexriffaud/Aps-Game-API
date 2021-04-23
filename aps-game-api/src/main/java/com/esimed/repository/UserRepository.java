package com.esimed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esimed.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	User findByLogin(String login);

}
