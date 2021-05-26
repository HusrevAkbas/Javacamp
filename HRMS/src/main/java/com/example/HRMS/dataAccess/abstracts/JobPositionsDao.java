package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobPosition;

public interface JobPositionsDao extends JpaRepository<JobPosition,Integer>{
}
