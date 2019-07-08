package com.fileupload;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fileupload.controller.FileUploadController;

@SpringBootApplication
public class FileUploadProjectApplication {

	public static void main(String[] args) {
		new File(FileUploadController.uploadDir).mkdir();
		SpringApplication.run(FileUploadProjectApplication.class, args);
	}

}
