/**
 * 
 */
package com.dailycodebuffer.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Praveena
 *
 */
@RestController
public class FileUploadController {

	@Value("${file.upload-dir}")
	String File_DIRECTORY;

	@PostMapping("/uploadfile")
	public ResponseEntity<Object> fileupload(@RequestParam("file") MultipartFile file) throws IOException {
		File file1 = new File("E:\\SpringBoot\\" + file.getOriginalFilename());
		file1.createNewFile();
		FileOutputStream fos = new FileOutputStream(file1);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>("The File Upload Successfullly", HttpStatus.OK);

	}

}
