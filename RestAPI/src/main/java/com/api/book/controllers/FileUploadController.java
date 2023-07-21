package com.api.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/files")
	public ResponseEntity<String> uploadFile(@RequestParam("File") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must contain File");
		}
		// File Upload Code
		try {
			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Images/")
						.path(file.getOriginalFilename()).toUriString());
//				return ResponseEntity.ok("File Uploaded");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}
