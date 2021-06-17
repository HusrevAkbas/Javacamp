package com.example.HRMS;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "hmrs",
				"api_key", "232133396821564",
				"api_secret", "aXFbQQZ2Wh1WLAMjJMTvn4ST9N4"));
		//BURADA ÇALIŞIYOR PROJE İÇİNDE NASIL KULLANILIR ÖĞRENİLECEK //
		//File file = new File("my_image.jpg");
		//Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id","second_image"));
		//System.out.println(uploadResult.get("url"));
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
}
