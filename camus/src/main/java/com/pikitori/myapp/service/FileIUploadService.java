package com.pikitori.myapp.service;

import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.pikitori.myapp.util.FileUtils;

@Repository
public class FileIUploadService {

	@Autowired
	private FileUtils utils;
	private String tmpfile;
	private String tmpfilename = "image";
	
	public void makemovie(List<MultipartFile> images) throws IOException {
		
		int i=0;
		for(MultipartFile f: images){
			
			String orgFileName = f.getOriginalFilename();
			String fileExtName = orgFileName.substring( orgFileName.lastIndexOf('.') + 1, orgFileName.length() );
			if(fileExtName.equals("jpg")){
				System.out.println("jpg");
			}else{
				System.out.println("png");
			}
			tmpfile = tmpfilename + (i++)+ "." + "png";
			System.out.println(tmpfile);
			utils.writeTmpFile(f,tmpfile);
			tmpfile = "";
		}
		utils.convertMp4();
	}
	
	public String uploadFiles(String orgFileName, MultipartFile mpf) throws IOException {
		
		String fileExtName = orgFileName.substring( orgFileName.lastIndexOf('.') + 1, orgFileName.length() );
		String saveFileName = utils.generateSaveFileName( fileExtName );
		saveFileName = utils.mkdir(saveFileName);
		return utils.writeFile(mpf, saveFileName);
	}
	
	public String thumbnail(String saveFileName, String orgFileName) throws Exception{
		return utils.makeThumbnail(saveFileName, orgFileName);
	}
	
}
