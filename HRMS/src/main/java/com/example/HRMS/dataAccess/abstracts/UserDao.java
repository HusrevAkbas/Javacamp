package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HRMS.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	User getByeMail(String email);
}
