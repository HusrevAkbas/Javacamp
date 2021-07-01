package com.example.HRMS.adapters;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	Map save(MultipartFile file);
}
