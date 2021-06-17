package com.example.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_experience")
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="work_place")
	private String workPlace;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_year")
	private int startYear;

	@Column(name="end_year", nullable = true)
	private Integer endYear;
	
	@ManyToOne
	@JsonIgnore
	private CurriculumVitae curriculumVitae;
	
}
