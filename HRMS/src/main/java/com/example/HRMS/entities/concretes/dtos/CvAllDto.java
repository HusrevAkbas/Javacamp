package com.example.HRMS.entities.concretes.dtos;

import java.util.Collection;
import com.example.HRMS.entities.concretes.CoverLetter;
import com.example.HRMS.entities.concretes.CvPhoto;
import com.example.HRMS.entities.concretes.ForeignLanguage;
import com.example.HRMS.entities.concretes.School;
import com.example.HRMS.entities.concretes.Technology;
import com.example.HRMS.entities.concretes.WorkExperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvAllDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
//	private Collection<School> schools;
//	private Collection<WorkExperience> workExperiences;
//	private Collection<ForeignLanguage> foreignLanguages;
//	private Collection<CvPhoto> cvPhoto;
//	private String github;
//	private String linkedIn;
//	private Collection<CoverLetter> coverLetters;
//	private Collection<Technology> technologies;	
}
