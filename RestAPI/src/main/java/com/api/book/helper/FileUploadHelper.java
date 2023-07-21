package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String Upload_Dir = "D:\\SpringBoot\\RestAPI\\src\\main\\resources\\static\\Images";
	public final String Upload_Dir = new ClassPathResource("static/Images/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {
		super();
	}

	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
//			InputStream stream = file.getInputStream();
//			byte data[] = new byte[stream.available()];
//			stream.read(data);
//			FileOutputStream fos = new FileOutputStream(Upload_Dir+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();

			Files.copy(file.getInputStream(), Paths.get(Upload_Dir + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;
	}

}
