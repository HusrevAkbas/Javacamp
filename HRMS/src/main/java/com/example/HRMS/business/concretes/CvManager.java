package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.CvService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.dataAccess.abstracts.CvDao;
import com.example.HRMS.entities.concretes.CurriculumVitae;
import com.example.HRMS.entities.concretes.dtos.CvAllDto;

@Service
public class CvManager implements CvService {
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}
	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.cvDao.findAll(),"tüm cvler listelendi");
	}
	@Override
	public DataResult<CvAllDto> getCvAllDto(int id) {
		return new SuccessDataResult<CvAllDto>(this.cvDao.getCvAllDto(id),"tüm cv bilgileri getirildi");
	}

}
