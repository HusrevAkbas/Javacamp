package com.example.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","users"})
public class Candidate extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity_no")
	private String nationalIdNumber;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@OneToOne(mappedBy = "candidate")
	private CurriculumVitae curriculumVitae;
}
