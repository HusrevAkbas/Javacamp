package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.SchoolService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.dataAccess.abstracts.SchoolDao;
import com.example.HRMS.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}
	@Override
	public DataResult<List<School>> findByGraduationYearOrderByDescent() {
		List<School> schoolList = this.schoolDao.findByGraduationYearIsNull();
		schoolList.addAll(this.schoolDao.findByGraduationYearNotNullOrderByGraduationYearDesc());
		return new SuccessDataResult<List<School>>(schoolList,"okullar mezuniyet yılına göre getirildi");
	}

}
