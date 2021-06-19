package com.example.HRMS.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryAdapter implements ImageService {
	private Cloudinary cloudinary;
	
	public CloudinaryAdapter() throws IOException {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "hmrs",
			"api_key", "232133396821564",
			"api_secret", "aXFbQQZ2Wh1WLAMjJMTvn4ST9N4"));
	}
	@Override
	public Map save(MultipartFile file) {
		try {
			Map updateResult = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return updateResult;
		} catch (IOException e) {

			System.out.println("yükleme hatası: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
