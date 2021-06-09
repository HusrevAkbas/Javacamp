package com.example.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer,city,jobPosition"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="release_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING ,pattern="dd-MM-yyyy")
	private LocalDate releaseDate;
	
	@Column(name="application_deadline")
	@JsonFormat(shape=JsonFormat.Shape.STRING ,pattern="dd-MM-yyyy")
	private LocalDate applicationDeadline;
	
	@Column(name="minimum_salary")
	private double minimumSalary;
	
	@Column(name="maximum_salary")
	private double maximumSalary;
	
	@Column(name="active_state")
	private boolean activeState;
	
	@ManyToOne
	private Employer employer;
	
	@ManyToOne
	private City city;
	
	@ManyToOne
	private JobPosition jobPosition;
	
	public void setReleaseDate() {
		this.releaseDate = LocalDate.now();
	}
}
