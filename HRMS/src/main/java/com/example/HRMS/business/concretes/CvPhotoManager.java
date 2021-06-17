package com.example.HRMS.business.concretes;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.HRMS.business.abstracts.CvPhotoService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.CvPhotoDao;
import com.example.HRMS.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService{

	private CvPhotoDao photoDao;
	private Cloudinary cloudinary;
	@Autowired
	public CvPhotoManager(CvPhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public DataResult<List<CvPhoto>> getAll() {
		return new SuccessDataResult<List<CvPhoto>>(this.photoDao.findAll(), "tüm fotoğraflar listelendi");
	}

	@Override
	public Result add(MultipartFile image) {
		CvPhoto photo = new CvPhoto();
		//Cloudinary entegrasyonu tamamlanamadı
		//cloudinary ile yüklenen fotoğraf linki yeni entityye eklenerek kaydedilecek
		this.photoDao.save(photo);
		return new SuccessResult("fotoğraf eklendi");
	}

}
