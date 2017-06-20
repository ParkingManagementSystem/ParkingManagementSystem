package org.springframework.samples.web.command;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping("/uploadFile.do")
	public String uploadFile(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile, Model model){
	    String savePath = "c:/Projects/";
//	    String savePath = request.getRealPath("folderName"); // 파일이 저장될 프로젝트 안의 폴더 경로
	     
	    String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
	    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
	    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
	     
	    String rename = onlyFileName + "_" + getCurrentDayTime() + extension; // fileName_20150721-14-07-50.jpg
	    String fullPath = savePath + "\\" + rename;
	     
	    if (!imgFile.isEmpty()) {
	        try {
	            byte[] bytes = imgFile.getBytes();
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
	            stream.write(bytes);
	            stream.close();
	            model.addAttribute("resultMsg", "파일을 업로드 성공!");
	        } catch (Exception e) {
	            model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
	        }
	    } else {
	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
	    }
	     
	    return "FileSend";
	}
	 
	public String getCurrentDayTime(){
	    long time = System.currentTimeMillis();
	    SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
	    return dayTime.format(new Date(time));
	}
}
