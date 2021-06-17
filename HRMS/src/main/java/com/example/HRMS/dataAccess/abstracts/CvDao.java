package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.CurriculumVitae;

public interface CvDao extends JpaRepository<CurriculumVitae, Integer>{

}
