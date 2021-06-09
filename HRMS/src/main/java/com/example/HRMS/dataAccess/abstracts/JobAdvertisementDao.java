package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HRMS.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> getByActiveStateTrue();
	List<JobAdvertisement> getByActiveStateTrueOrderByReleaseDate();
	List<JobAdvertisement> getByEmployerIdAndActiveStateTrue(int companyId);
	JobAdvertisement getById(int id);
}
