package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HRMS.entities.concretes.JobPosition;

@Repository
public interface JobPositionsDao extends JpaRepository<JobPosition,Integer>{
	JobPosition getByTitle(String title);
}
