package com.pikitori.myapp.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileUtils {

	private static final String SAVE_PATH = "D:\\piki-upload";
	private static final String SAVE_TMP_PATH = "D:\\piki-upload-tmp";
	
	private SecureRandom random = new SecureRandom();
	
	public String mkdir(String saveFileName) {
		int location = saveFileName.lastIndexOf('.');
		String first = saveFileName.substring(location -1 ,location);
		String second = saveFileName.substring(location -2 ,location-1);
		File firstdir = new File(SAVE_PATH,first);
		if(! firstdir.exists()){
			firstdir.mkdirs();
		}
		File seconddir = new File(firstdir,second);
		if(!seconddir.exists() ){
			seconddir.mkdirs();
		}
		saveFileName = first+File.separator+second+File.separator+saveFileName;
		return saveFileName;
	}
	
	public String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		
		fileName += new BigInteger(64, random).toString(32);
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);

		return fileName;
	}

	public String makeThumbnail(String saveFileName, String fileName)throws Exception{
		BufferedImage sourceImg = ImageIO.read(new File(SAVE_PATH + File.separator + saveFileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		String uri = saveFileName.substring(0,saveFileName.lastIndexOf("."));
		System.out.println("formatName :" + formatName + "|| uri : "+ uri + "filename: "+ fileName);
		
		String thumbnailName = SAVE_PATH + File.separator +uri + "s_" + fileName;
		System.out.println("thumbnailName :"+ thumbnailName);
		File newFile = new File(thumbnailName);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(SAVE_PATH.length(),thumbnailName.length()).replace(File.separatorChar, '/');
	}

	
	public void writeTmpFile(MultipartFile multipartFile,String tmpfilename) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		String dirpath = SAVE_TMP_PATH  + File.separator + tmpfilename;
		
		File dir = new File(SAVE_TMP_PATH);
		if(!dir.exists()){
			dir.mkdir();
		}
		
/*		FileOutputStream fos = new FileOutputStream( dirpath );
		fos.write( fileData );
		fos.close();*/
		BufferedImage bi = ImageIO.read(new ByteArrayInputStream(fileData));
		ImageIO.write(bi, "png", new File(dirpath)); 
		
		
	};
	
	private static final String fResult = "D:\\result.mp4";
	private static final String ffmpegPath = "/Users/admin/Downloads/source/ffmpeg-win64/ffmpeg/bin/ffmpeg.exe";
	public void convertMp4(){
		
		String fOriginal = SAVE_TMP_PATH+File.separator+"image%00d"+".png"; // 실시간으로 업로드되는 파일

		String[] cmdLine = new String[] {
				ffmpegPath, 
				"-framerate",
				"5",
				"-i",
				fOriginal,
				"-vf", "scale=w=720:h=-1:force_original_aspect_ratio=decrease", 
//				"-s:v", "1280:720",
				"-c:v", "libx264",
				"-profile:v", "high -level 4.2", 
				"-crf", "0",
				"-pix_fmt", "yuvj420p", 
//				"-vf", "'setpts=10*PTS'", 
				fResult ,"-y"};
		
		try {
			byCommonsExec(cmdLine);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void byCommonsExec(String[] command)throws IOException,InterruptedException {
	    DefaultExecutor executor = new DefaultExecutor();
	    CommandLine cmdLine = CommandLine.parse(command[0]);
	    for (int i=1, n=command.length ; i<n ; i++ ) {
	        cmdLine.addArgument(command[i]);
	    }
	    executor.execute(cmdLine);
	}

	public String writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		
		byte[] fileData = multipartFile.getBytes();
		String dirpath = SAVE_PATH + File.separator + saveFileName;
		FileOutputStream fos = new FileOutputStream( dirpath );
		fos.write( fileData );
		fos.close();
		
		return saveFileName;
	}
	
}
