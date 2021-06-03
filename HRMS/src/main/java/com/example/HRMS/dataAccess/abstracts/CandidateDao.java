package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HRMS.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByNationalIdNumber(String nationalIdNumber);
}
