package com.example.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curriculum_vitaes")
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linked_in")
	private String linkedIn;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<School> schools;
	
	@JsonIgnore
	@OneToOne
	private Candidate candidate;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Technology> technologies;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CvPhoto> cvPhoto;
	
}
