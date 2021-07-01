package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.HRMS.entities.concretes.CurriculumVitae;
import com.example.HRMS.entities.concretes.dtos.CvAllDto;

public interface CvDao extends JpaRepository<CurriculumVitae, Integer>{
	//COLLECTIONS OLMADAN ÇALIŞIYOR. ÇÖZÜLMELİ
	@Query("select new com.example.HRMS.entities.concretes.dtos.CvAllDto("
			+ "cv.id, can.firstName, can.lastName, can.eMail) "
//			+ "cv.schools, cv.workExperiences, cv.foreignLanguages, "
//			+ "cv.cvPhoto, cv.github, cv.linkedIn, cv.coverLetters, cv.technologies) "
			+ "From CurriculumVitae cv Inner Join cv.candidate can on cv.id=:id")
	CvAllDto getCvAllDto(int id);
}
