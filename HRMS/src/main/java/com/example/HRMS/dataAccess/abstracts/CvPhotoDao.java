package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer> {

}
