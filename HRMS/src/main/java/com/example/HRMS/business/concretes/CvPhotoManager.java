package com.example.HRMS.business.concretes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.HRMS.adapters.ImageService;
import com.example.HRMS.business.abstracts.CvPhotoService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.CvDao;
import com.example.HRMS.dataAccess.abstracts.CvPhotoDao;
import com.example.HRMS.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService{

	private CvPhotoDao photoDao;
	private ImageService imageService;
	private CvDao cvDao;
	@Autowired
	public CvPhotoManager(CvPhotoDao photoDao, ImageService imageService, CvDao cvDao) {
		super();
		this.photoDao = photoDao;
		this.imageService = imageService;
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<CvPhoto>> getAll() {
		return new SuccessDataResult<List<CvPhoto>>(this.photoDao.findAll(), "tüm fotoğraflar listelendi");
	}

	@Override
	public Result add(MultipartFile image, int cvId) {
		CvPhoto photo = new CvPhoto();
		Map uploadResult = this.imageService.save(image);
		//String url = uploadResult.get("url").toString();
		//System.out.println(uploadResult.get("url").getClass());
		photo.setUrl(uploadResult.get("url").toString());
		photo.setCurriculumVitae(this.cvDao.getById(cvId));
		this.photoDao.save(photo);
		return new SuccessResult("fotoğraf eklendi");
	}

}
