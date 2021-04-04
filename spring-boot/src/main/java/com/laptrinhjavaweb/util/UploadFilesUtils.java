package com.laptrinhjavaweb.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFilesUtils {
	public static String saveUploadFiles(MultipartFile[] files) throws IOException{
		// Make sure directory exists!
		File uploadDir = new File(AppConstants.UPLOAD_DIR);
		
		// Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadDir.exists()) {
        	uploadDir.mkdirs();
        }
		
		StringBuilder sb = new StringBuilder();
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue;
			}
			String uploadFilePath = AppConstants.UPLOAD_DIR+"/"+file.getOriginalFilename();
			
			byte[] bytes;
				bytes = file.getBytes();
				Path path = Paths.get(uploadFilePath);
				Files.write(path, bytes);
				sb.append(file.getOriginalFilename()+"<br>");
		}
		String pathName = sb.toString();
		return StringUtils.isEmpty(pathName) ? null : pathName.substring(0, pathName.length() - 4);
		
	}
	
	public static MultipartFile[] convertMultipartFile(String pathName) {
		String[] mutiFineName = null;
		if (pathName.contains("<br>")) {
			mutiFineName = "pathName".split("<br>");
		} else {
			mutiFineName = new String[]{pathName};
		}
		
		List<MultipartFile> listMultipartFile =new ArrayList<MultipartFile>();
		
		for (String fileName : mutiFineName) {
			Path path = Paths.get(AppConstants.UPLOAD_DIR+"/"+fileName);
			String name = "fileName";
			String originalFileName = "fileName";
			String contentType = "text/plain";
			byte[] content = null;
			try {
			    content = Files.readAllBytes(path);
			} catch (final IOException e) {
			}
			MultipartFile result = new MockMultipartFile(name,
			                     originalFileName, contentType, content);
			
			listMultipartFile.add(result);
		}
		//convert list to array
		MultipartFile[] multipartFileArray = new MultipartFile[listMultipartFile.size()];
		multipartFileArray = listMultipartFile.toArray(multipartFileArray);
		return multipartFileArray;
	}
	
}
