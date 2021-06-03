package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.HRMS.entities.concretes.VerificationEmail;

@Repository
public interface VerificationEmailDao extends JpaRepository<VerificationEmail, Integer>{
	VerificationEmail getByUserId(int id);
}
